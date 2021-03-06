package es.ucm.fdi.iw.control;

import java.util.List;

import javax.persistence.EntityManager;
import javax.servlet.http.HttpSession;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import es.ucm.fdi.iw.model.Candidatura;
import es.ucm.fdi.iw.model.Usuario;



@Controller()
@RequestMapping("busquedaPerfil")
public class BusquedaPerfilController {
	private static final Logger log = LogManager.getLogger(BusquedaPerfilController.class);
	@Autowired 
	private EntityManager entityManager;
	private final int NUM_ELEMENTOS_PAGINA=2;
	
	  
	  //Metodos nuevos
	  @GetMapping("")
	  public String busquedaPerfil(HttpSession session,Model model) {
		  
	    List<Usuario> users = entityManager.createNamedQuery("Usuario.getAllUsers", Usuario.class).getResultList();
		 model.addAttribute("numeroPaginas", Math.ceil((double)users.size()/NUM_ELEMENTOS_PAGINA));
	     users=users.subList(0,NUM_ELEMENTOS_PAGINA);
		 model.addAttribute("usuarios", users);
		  return "busquedaPerfil";
	  }
	  
	  @GetMapping("/busca")
		public String postSearch(Model model, HttpSession session, @RequestParam(required = true, defaultValue = "1") int indicePagina, @RequestParam String patron ) {
			String patronParaLike = "%"+patron+"%";
			List<Usuario> usuarios = null;
			
			if (patron.isEmpty()) { 
				usuarios = entityManager.createQuery("select u from Usuario u", Usuario.class).getResultList();
			} else {
				usuarios = entityManager.createNamedQuery("Usuario.searchByNombre", Usuario.class)
						.setParameter("nombre", patronParaLike).getResultList();			
			}
			model.addAttribute("numeroPaginas", Math.ceil((double)usuarios.size()/NUM_ELEMENTOS_PAGINA));
			if (indicePagina*NUM_ELEMENTOS_PAGINA <= usuarios.size())
				usuarios=usuarios.subList((indicePagina-1)*NUM_ELEMENTOS_PAGINA, indicePagina*NUM_ELEMENTOS_PAGINA);
			else 
				usuarios=usuarios.subList((indicePagina-1)*NUM_ELEMENTOS_PAGINA, usuarios.size());

					
			model.addAttribute("resultadoBusqueda", usuarios);
			model.addAttribute("patron", patron);

			return "fragments/resultadoBusquedaPerfiles";
		}

		@GetMapping("/tags")
		public String postSearchByTag(Model model, HttpSession session, @RequestParam(required = true, defaultValue = "1") int indicePagina, @RequestParam String tag ) {
			
			List<Usuario> usuarios = entityManager.createNamedQuery("Usuario.searchByNombre", Usuario.class)
					.setParameter("tag", tag).getResultList();

			if(usuarios.size()>1){
				model.addAttribute("numeroPaginas", Math.ceil((double)usuarios.size()/NUM_ELEMENTOS_PAGINA));
				usuarios=usuarios.subList((indicePagina-1)*NUM_ELEMENTOS_PAGINA, indicePagina*NUM_ELEMENTOS_PAGINA);
			}

			model.addAttribute("resultadoBusqueda", usuarios);
			model.addAttribute("tag", tag);

			return "fragments/resultadoBusquedaPerfiles";
		}
	  
	  


}
