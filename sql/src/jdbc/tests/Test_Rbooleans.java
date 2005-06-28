/*
 * The contents of this file are subject to the MonetDB Public License
 * Version 1.1 (the "License"); you may not use this file except in
 * compliance with the License. You may obtain a copy of the License at
 * http://monetdb.cwi.nl/Legal/MonetDBLicense-1.1.html
 *
 * Software distributed under the License is distributed on an "AS IS"
 * basis, WITHOUT WARRANTY OF ANY KIND, either express or implied. See the
 * License for the specific language governing rights and limitations
 * under the License.
 *
 * The Original Code is the Monet Database System.
 *
 * The Initial Developer of the Original Code is CWI.
 * Portions created by CWI are Copyright (C) 1997-2005 CWI.
 * All Rights Reserved.
 */

import java.sql.*;

public class Test_Rbooleans {
	public static void main(String[] args) throws Exception {
		Class.forName("nl.cwi.monetdb.jdbc.MonetDriver");
		Connection con = DriverManager.getConnection(args[0]);
		Statement stmt = con.createStatement();
		ResultSet rs = null;
		//DatabaseMetaData dbmd = con.getMetaData();

		con.setAutoCommit(false);
		// >> false: auto commit should be off now
		System.out.println("0. false\t" + con.getAutoCommit());

		try {
			stmt.executeUpdate("CREATE TABLE table_Test_Rbooleans ( id int, tiny_int tinyint, small_int smallint, medium_int mediumint, \"integer\" int, big_int bigint, a_real real, a_float float, a_double double, a_decimal decimal(8,2), a_numeric numeric(8), bool boolean, a_char char(4), b_char char(5), a_varchar varchar(20), PRIMARY KEY (id) )");

			// all falses
			stmt.executeUpdate("INSERT INTO table_Test_Rbooleans VALUES (1,                0,                  0,                    0,           0,              0,         0.0,           0.0,             0.0,                    0.0,                    0,        false,         'fals',        'false',               'false')");
			// all trues
			stmt.executeUpdate("INSERT INTO table_Test_Rbooleans VALUES (2,                1,                  1,                    1,           1,              1,         1.0,           1.0,             1.0,                    1.0,                    1,         true,         'true',        'true ',                'true')");
			// sneakier
			stmt.executeUpdate("INSERT INTO table_Test_Rbooleans VALUES (3,                2,                  3,                    4,           5,              6,         7.1,           8.2,             9.3,                   10.4,                   11,         true,         'TrUe',        'fAlSe',          'true/false')");
			stmt.executeUpdate("INSERT INTO table_Test_Rbooleans VALUES (4,                2,                  3,                    4,           5,              6,         7.1,           8.2,             9.3,                   10.4,                   11,         true,         't   ',        'f    ',          'TRUE      ')");

			rs = stmt.executeQuery("SELECT * FROM table_Test_Rbooleans ORDER BY id ASC");

			// all should give false
			rs.next();
			System.out.println("1. " + rs.getInt("id") + ", " + rs.getBoolean("tiny_int") + ", " + rs.getBoolean("small_int") + ", " + rs.getBoolean("medium_int") + ", " + rs.getBoolean("integer") + ", " + rs.getBoolean("big_int") + ", " + rs.getBoolean("a_real") + ", " + rs.getBoolean("a_double") + ", " + rs.getBoolean("a_decimal") + ", " + rs.getBoolean("a_numeric") + ", " + rs.getBoolean("bool") + ", " + rs.getBoolean("a_char") + ", " + rs.getBoolean("b_char") + ", " + rs.getBoolean("a_varchar"));
			// all should give true except the one before last
			rs.next();
			System.out.println("2. " + rs.getInt("id") + ", " + rs.getBoolean("tiny_int") + ", " + rs.getBoolean("small_int") + ", " + rs.getBoolean("medium_int") + ", " + rs.getBoolean("integer") + ", " + rs.getBoolean("big_int") + ", " + rs.getBoolean("a_real") + ", " + rs.getBoolean("a_double") + ", " + rs.getBoolean("a_decimal") + ", " + rs.getBoolean("a_numeric") + ", " + rs.getBoolean("bool") + ", " + rs.getBoolean("a_char") + ", " + rs.getBoolean("b_char") + ", " + rs.getBoolean("a_varchar"));
			// should give true for all but the last two
			rs.next();
			System.out.println("3. " + rs.getInt("id") + ", " + rs.getBoolean("tiny_int") + ", " + rs.getBoolean("small_int") + ", " + rs.getBoolean("medium_int") + ", " + rs.getBoolean("integer") + ", " + rs.getBoolean("big_int") + ", " + rs.getBoolean("a_real") + ", " + rs.getBoolean("a_double") + ", " + rs.getBoolean("a_decimal") + ", " + rs.getBoolean("a_numeric") + ", " + rs.getBoolean("bool") + ", " + rs.getBoolean("a_char") + ", " + rs.getBoolean("b_char") + ", " + rs.getBoolean("a_varchar"));
			// should give true for all but the last three
			rs.next();
			System.out.println("4. " + rs.getInt("id") + ", " + rs.getBoolean("tiny_int") + ", " + rs.getBoolean("small_int") + ", " + rs.getBoolean("medium_int") + ", " + rs.getBoolean("integer") + ", " + rs.getBoolean("big_int") + ", " + rs.getBoolean("a_real") + ", " + rs.getBoolean("a_double") + ", " + rs.getBoolean("a_decimal") + ", " + rs.getBoolean("a_numeric") + ", " + rs.getBoolean("bool") + ", " + rs.getBoolean("a_char") + ", " + rs.getBoolean("b_char") + ", " + rs.getBoolean("a_varchar"));
		} catch (SQLException e) {
			System.out.println("failed :( "+ e.getMessage());
			System.out.println("ABORTING TEST!!!");
		}

		con.rollback();
		con.close();
	}
}
