package services;

import java.util.List;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import com.google.gson.Gson;
import entity.Aluno;
import persistence.AlunoDao;

@Path("/aluno")
public class ServiceAluno {

	@POST
	@Path("/incluir/{nome}/{email}")
	@Produces("text/plain")
	public String incluir(@FormParam("nome") String nome,
			               @FormParam("email") String email
			 ){
	  try{
	  new AlunoDao().create(new Aluno(null, nome,email));
	  String msg="Dados Gravados";
      return "Dados Gravados";
	  }catch(Exception ex){
		  String msg="Error :" + ex.getMessage();
		  return "Error :" + ex.getMessage();
	  }
	}
	
	
	
	@POST
	@Path("/gravar")
	@Produces("text/plain")
	public Response gravar(@FormParam("nome") String nome,
			               @FormParam("email") String email
			 ){
	  try{
	  new AlunoDao().create(new Aluno(null, nome,email));
	  String msg="Dados Gravados";
      return Response.status(200).entity(msg).build();
	  }catch(Exception ex){
		  String msg="Error :" + ex.getMessage();
		  return Response.status(200).entity(msg).build();
	  }
	}
	
	@GET
	@Path("/listar")
	@Produces("application/json")
	public String listar(){
	  try{
	  List<Aluno> lst=   new AlunoDao().findAll();
	  return new Gson().toJson(lst);
	  }catch(Exception ex){
		  ex.printStackTrace();
		  return  "Error:" + ex.getMessage();
	  }
	}
	
	@GET
	@Path("/listarCodigo/{cod}")
	@Produces("application/json")
	public String listarCodigo(@PathParam("cod") String cod){
	  try{
	  Aluno aluno= new AlunoDao().findByCode(new Integer(cod));
	  return new Gson().toJson(aluno);
	  }catch(Exception ex){
		  return  "Error:" + ex.getMessage();
	  }
	}
	
	
	@GET
	@Path("/alterar/{cod}/{nome}/{email}")
	@Produces("text/plain")
	public String alterar(@PathParam("cod") String cod,
			@PathParam("nome") String nome,
			@PathParam("email") String email){
	  try{
	  Aluno a = new Aluno(new Integer(cod), nome, email);
	  new AlunoDao().update(a);
	  return "Dados Alterados";
	  }catch(Exception ex){
		  return  "Error:" + ex.getMessage();
	  }
	}
	
	@GET
	@Path("/excluir/{cod}")
	@Produces("text/plain")
	public String excluir(@PathParam("cod") String cod){
	  try{
	    new AlunoDao().delete(new Integer(cod));
	     return "Aluno Exluir";
	  }catch(Exception ex){
		  return  "Error:" + ex.getMessage();
	  }
	}

	
	
	
}
