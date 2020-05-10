package projectPcPartReview;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.sql.SQLException;

import javax.swing.JOptionPane;

class defaultData extends loginSQL{
	defaultData() {
		try {
			String dir=System.getProperty("user.dir").replace("\\","/");
			File pcRds=new File((dir+"/src/resource/partdata.txt"));
			BufferedReader pcRd=new BufferedReader(new FileReader(pcRds));
			String sqlLine="";
			String[][] replaces= {{"Intel core","max","Samsung","notebook","Coffee Lake","Comet Lake","emtek","Geforce","GALAX","Toshiba"},
					{"인텔 코어","최대","삼성전자","노트북용","커피레이크","코멧레이크","이엠텍","지포스","갤럭시","도시바"}};
			while((sqlLine=pcRd.readLine())!=null){
				try {
					for(int i=0;i<replaces[0].length;i++)
						sqlLine=sqlLine.replace(replaces[0][i],replaces[1][i]);
					ps=con.prepareStatement(sqlLine);
					ps.executeQuery();
				}
				catch(SQLException f) {
					System.out.println(sqlLine);
				}
			}
			pcRd.close();
		}
		catch(IOException e){
			JOptionPane.showMessageDialog(singlePartUI.spw,"사전데이터 입력에 실패 했습니다.","data check",JOptionPane.WARNING_MESSAGE,null);
		}
	}
}
class defaultPartData{
	public static void main(String[] args) {
		new defaultData();
	}
}