package ba.bitcamp.homeworkWeekend8.task;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.Arrays;
import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;

public class FileAllocator extends JPanel {

	private static final long serialVersionUID = 6278377678788046460L;

	private File selected = null;

	File documents = null;

	private File selectedToDelete;

	private Path destination = null;
	private JButton browse = new JButton("Browse File");
	private JButton select = new JButton("Select Folder");
	private JButton delete = new JButton("Delete File");
	private JPanel buttons = new JPanel();
	private JPanel fileList = new JPanel();

	private DefaultListModel documentsListModel = new DefaultListModel();
	private JList documentsList = new JList(documentsListModel);

	private DefaultListModel picturesListModel = new DefaultListModel();
	private JList picturesList = new JList(picturesListModel);

	private DefaultListModel audioListModel = new DefaultListModel();
	private JList audioList = new JList(audioListModel);

	private DefaultListModel videoListModel = new DefaultListModel();
	private JList videoList = new JList(videoListModel);

	private DefaultListModel otherListModel = new DefaultListModel();
	private JList otherList = new JList(otherListModel);

	private ArrayList<String> extensionsText = new ArrayList<>(Arrays.asList(
			"txt", "docx", "md", "doc", "pdf", "log", "msg", "odt", "pages",
			"rtf", "tex", "wpd", "wps", "csv", "dat", "pps", "ppt", "pptx",
			"sdf", "xml", "xlr", "xls", "xlsx"));

	private ArrayList<String> extensionsPictures = new ArrayList<>(
			Arrays.asList("bmp", "dds", "gif", "jpg", "png", "psd", "tga",
					"thm", "tif", "tiff", "yuv"));

	private ArrayList<String> extensionsAudio = new ArrayList<>(
			Arrays.asList("aif", "iff", "m3u", "m4u", "mid", "mp3", "mpa",
					"ra", "wav", "wma"));

	private ArrayList<String> extensionsVideo = new ArrayList<>(Arrays.asList(
			"3g2", "3gp", "asf", "asx", "avi", "flv", "m4v", "mov", "mp4",
			"mpg", "rm", "srt", "swf", "vob", "wmv"));

	public FileAllocator() {
		setLayout(new BorderLayout());

		browse.addActionListener(new BrowseAction());

		select.addActionListener(new SearchAction());

		buttons.setLayout(new GridLayout(2, 1));
		buttons.add(select);
		buttons.add(browse);
		add(buttons, BorderLayout.NORTH);
		fileList.setBorder(BorderFactory.createTitledBorder("Files"));
		fileList.setLayout(new BorderLayout());

		fileList.setLayout(new GridLayout(1, 5));

		createList(fileList, documentsList, "Documents");
		createList(fileList, picturesList, "Pictures");
		createList(fileList, audioList, "Audio");
		createList(fileList, videoList, "Video");
		createList(fileList, otherList, "Other");

		add(fileList, BorderLayout.CENTER);
		add(delete, BorderLayout.SOUTH);

		delete.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				deleteSelected(documentsList, documentsListModel);
				deleteSelected(picturesList, picturesListModel);
				deleteSelected(audioList, audioListModel);
				deleteSelected(videoList, videoListModel);
				deleteSelected(otherList, otherListModel);
			}
		});

	}

	private void createList(JPanel panel, JList list, String title) {
		panel.add(list);
		panel.add(new JScrollPane(list));
		list.setBorder(BorderFactory.createTitledBorder(title));
	}

	private void deleteSelected(JList list, DefaultListModel listModel) {
		String deletedPath = selectedToDelete.getPath() + "\\"
				+ list.getModel().getElementAt(list.getSelectedIndex());
		File deleted = new File(deletedPath);
		listModel.remove(list.getSelectedIndex());
		deleted.delete();
	}

	private class SearchAction implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			JFileChooser open = new JFileChooser();
			open.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
			int option = open.showOpenDialog(null);
			if (option == open.APPROVE_OPTION) {
				selected = open.getSelectedFile();

				fillList("Documents", documentsList, documentsListModel);
				fillList("Pictures", picturesList, picturesListModel);
				fillList("Audio", audioList, audioListModel);
				fillList("Video", videoList, videoListModel);
				fillList("Other", otherList, otherListModel);

			}
		}
	}

	private void fillList(String folder, JList list, DefaultListModel listModel) {
		selectedToDelete = new File(selected.getPath() + "/" + folder);

		if (selectedToDelete.isDirectory() == false) {
			if (selectedToDelete.exists() == false) {
				listModel.clear();
			}
		} else {
			for (int i = 0; i < selectedToDelete.list().length; i++) {
				listModel.add(i, selectedToDelete.list()[i]);
			}
			list.setVisibleRowCount(5);
			list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		}
	}

	private class BrowseAction implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			JFileChooser open = new JFileChooser();
			open.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
			int option = open.showOpenDialog(null);

			if (option == open.APPROVE_OPTION) {

				File file = open.getSelectedFile();
				Path target = Paths.get(file.getPath());

				String extension = file.getName().substring(
						file.getName().lastIndexOf(".") + 1);

				if (extensionsText.contains(extension)) {
					documents = new File(selected.getPath() + "/Documents");
					copyFileInDirectory(documents, file, destination, target,
							documentsListModel);
				} else if (extensionsAudio.contains(extension)) {
					File audio = new File(selected.getPath() + "/Audio");
					copyFileInDirectory(audio, file, destination, target,
							audioListModel);
				} else if (extensionsPictures.contains(extension)) {
					File pictures = new File(selected.getPath() + "/Pictures");
					copyFileInDirectory(pictures, file, destination, target,
							picturesListModel);
				} else if (extensionsVideo.contains(extension)) {
					File video = new File(selected.getPath() + "/Video");
					copyFileInDirectory(video, file, destination, target,
							videoListModel);
				} else {
					File other = new File(selected.getPath() + "/Other");
					copyFileInDirectory(other, file, destination, target,
							otherListModel);
				}
			}
		}
	}

	private void copyFileInDirectory(File directory, File file,
			Path destination, Path target, DefaultListModel listModel) {
		if (directory.exists()) {
			destination = Paths.get(directory + "/" + file.getName());
		} else {
			directory.mkdir();
			destination = Paths.get(directory + "/" + file.getName());
		}
		try {
			Files.copy(target, destination, StandardCopyOption.REPLACE_EXISTING);
			listModel.addElement(file.getName());
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}

}
