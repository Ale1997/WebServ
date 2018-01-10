package persistence;

import java.util.ArrayList;
import java.util.List;

import entity.Aluno;

public class AlunoDao extends Dao{
	
	public void create(Aluno a) throws Exception{
		open();
		 stmt = con.
 prepareStatement("insert into aluno values (null,?,?)");
		  stmt.setString(1, a.getNome());
		  stmt.setString(2, a.getEmail());
		  stmt.execute();
		  stmt.close();
		close();
	}
	
	public void update(Aluno a) throws Exception{
		open();
		 stmt = con.prepareStatement
 ("update aluno set nome=?,email=? where idAluno=?");
		  stmt.setString(1, a.getNome());
		  stmt.setString(2, a.getEmail());
		  stmt.setInt(3, a.getIdAluno());
		  stmt.execute();
		  stmt.close();
		close();
	}
	
	
	public void delete(Integer cod) throws Exception{
		open();
		 stmt = con.prepareStatement
 ("delete from aluno where idAluno=?");
		  stmt.setInt(1, cod);
		  stmt.execute();
		  stmt.close();
		close();
	}
	
	
	public List<Aluno> findAll() throws Exception{
	   open();
	   stmt = con.prepareStatement("select * from aluno");
	   rs = stmt.executeQuery();
	   List<Aluno> lst = new ArrayList<Aluno>();
	   while(rs.next()){
		   Aluno a =new Aluno();
		    a.setIdAluno(rs.getInt(1));
		    a.setNome(rs.getString(2));
		    a.setEmail(rs.getString(3));
		   lst.add(a);
	   }
      close();
	   return lst;
	}
	
	public Aluno findByCode(Integer cod) throws Exception{
		   open();
    stmt = con.
  prepareStatement("select * from aluno where idAluno=?");
        stmt.setInt(1, cod);
		   rs = stmt.executeQuery();
		   Aluno a = null;
		   if(rs.next()){
			  a =new Aluno();
			    a.setIdAluno(rs.getInt(1));
			    a.setNome(rs.getString(2));
			    a.setEmail(rs.getString(3));
			 
		   }
	       close();
		   return a;
		}
	

	public static void main(String[] args) {
		try {
			AlunoDao ad = new AlunoDao();
			System.out.println(ad.findAll());
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

}
