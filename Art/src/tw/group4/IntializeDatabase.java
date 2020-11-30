package tw.group4;

import tw.group4._04_.init.CreateTable;
import tw.group4._11_.createTable.CreateTableSA;
import tw.group4._11_.createTable.Create_SA2;
import tw.group4._14_.init.APTableReset;
import tw.group4._18_._18_io.createTableCo;
import tw.group4._35_.init.model.CreateTableInsertDataService;

public class IntializeDatabase {
	
	public static void main(String[] args) {
		
//		全部執行完畢需時30-60秒
		new CreateTableInsertDataService().execute35();
		new APTableReset().execute14();
		new Create_SA2().execute11f();
		new CreateTableSA().execute11b();
		new CreateTable().execute04();
		new createTableCo().execute18();
	}
}
