package projectPcPartReview;

import javax.swing.ImageIcon;

public class resourceFile {
	static String[] iconName={"search.png","load.png","save.png","delete.png"};
	static ImageIcon[] singlePartIcons=new ImageIcon[iconName.length];
	resourceFile(){
		int count=0;
		for(String name:iconName) {
			singlePartIcons[count]=new ImageIcon(name);
			count++;
		}
	}
}
