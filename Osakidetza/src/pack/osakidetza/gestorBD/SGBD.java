package pack.osakidetza.gestorBD;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

public class SGBD {
	
	private static SGBD mSGDB = new SGBD();
	
	private SGBD()
	{		
	}
	
	public static SGBD getSGBD()
	{
		return mSGDB;
	}
	
	/**
	 * devuelve la conexion con la base de datos
	 * @return conexion con la BD
	 */
	@SuppressWarnings("finally")
	private Connection getConexion()
	{
		Connection conexion = null;
		 try {
 
        MysqlDataSource dataSource = new MysqlDataSource();
        dataSource.setUser("doctor");
        dataSource.setPassword("x6a4Fj8q");
        dataSource.setDatabaseName("Estudio");
        //BD REMOTA
        //dataSource.setServerName("80.103.204.186");	
        //BD en el propio host.
        dataSource.setServerName("localhost");

         conexion = dataSource.getConnection();
         
		 } catch (SQLException e) {
			System.out.println("Error al conectar a la base de datos");
			e.printStackTrace();
		}
		finally
		{
			return conexion;
		}
	}
	
	/**
	 * ejecuta ordenes SQL que no devuelvan resultado
	 */
	public boolean execSQL(String orden)
	{
		Connection conexion = this.getConexion();
		
		if(conexion != null)
		{
			
			try {
				//creamos la sentencia
				Statement s = conexion.createStatement();
				//ejecutamos la orden
				boolean updated =s.executeUpdate(orden)!=0;//Si se ejecuta correctamente el valor es 1, si no 0
				//cerramos la conexion
				conexion.close();
				return updated;
			
			} catch (SQLException e) {
				System.out.println("Error al ejecutar la sentencia SQL");
				e.printStackTrace();
			}
		}
		return false;
	}
	
	/**
	 * ejecuta ordenes SQL que devuelvan resultado
	 * @param consulta la sentencia a ejecutar
	 * @return Devuelve un ResultadoSQL
	 */
	public ResultadoSQL consultaSQL(String consulta)
	{
		Connection conexion = this.getConexion();
		
		if(conexion != null)
		{
			
			try {
					//creamos la sentencia
					Statement s = conexion.createStatement();
					//obtenemos su resultado
					ResultSet rs = s.executeQuery(consulta);
					//creamos el ResultadoSQL a devolver
					//la conexion se cerrara al ejecutar el close del ResultSet
					return new ResultadoSQL(rs);
			
			} catch (SQLException e) {
				System.out.println("Error al ejecutar la sentencia SQL");
			}
	
		}
		//si falla la conexion o la ejecucion de la sentencia,
		//se devuelve un resultado vacio
		return new ResultadoSQL();
	}

}
