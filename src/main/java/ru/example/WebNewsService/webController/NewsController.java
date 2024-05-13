package ru.example.WebNewsService.webController;

import java.util.concurrent.ExecutionException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import ru.example.WebNewsService.services.JsonService;
import ru.example.WebNewsService.services.MicroserviceClientCreatorNews;

@Controller
@RequestMapping("/news")
public class NewsController {

	@Autowired
	private MicroserviceClientCreatorNews сlient;

	@Autowired
	private JsonService jsonService;

	@GetMapping("/all")
	public String showAllNews(Model model) throws ExecutionException, InterruptedException {
		String newsJson = сlient.returnEverything();
		Object newsObject = jsonService.jsonToObject(newsJson, Object.class).get(); 
																					
		model.addAttribute("news", newsObject);
		return "all_news";
	}

	@GetMapping("/{id}")
	public String showNewsByTopic(Model model, @PathVariable Long id) throws ExecutionException, InterruptedException {
		String newsJson = сlient.returnById(id);
		Object newsObject = jsonService.jsonToObject(newsJson, Object.class).get(); 
																					
		model.addAttribute("news", newsObject);
		return "id_news";
	}

}
