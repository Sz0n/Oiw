package app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ChampionApi {
    private ChampionManager championManager;

    @Autowired
    public ChampionApi(ChampionManager championManager) {
        this.championManager = championManager;
    }

    @GetMapping("/")
    public String wyswietl() {
        return "RestFul Api na Oiw";
    }

    @GetMapping("/champs")
    public List<Champion> getChampions() {
        return championManager.getChampions();
    }

    @GetMapping("/champs/{id}")
    public Champion getChampion(@PathVariable(value = "id") int id) {
        return championManager.getChampion(id);
    }

    @PostMapping("/champs")
    public void addChampion(@RequestBody Champion champion){
        championManager.addChampion(champion);
    }

    @DeleteMapping("/champs/{id}")
    public void delChampion(@PathVariable(value = "id") int id){
        championManager.delChampion(id);
    }

    @PutMapping("/champs/{id}")
    public void putChampion(@PathVariable(value = "id") int id, @RequestBody Champion champion) {
        championManager.putChampion(id, champion);
    }

    @PatchMapping("champs/{id}")
    public void patchChampion(@PathVariable(value = "id") final int id,
                         @RequestParam(value = "name", required = false) String name,
                         @RequestParam(value = "title", required = false) String title,
                         @RequestParam(value = "classOfChampion", required = false) String classOfChampion,
                         @RequestParam(value = "prefLine", required = false) String prefLine) {

        if (name != null)
            championManager.getChampion(id).setName(name);
        if (title != null)
            championManager.getChampion(id).setTitle(title);
        if (classOfChampion != null)
            championManager.getChampion(id).setclassOfChampion(classOfChampion);
        if (prefLine != null)
            championManager.getChampion(id).setPrefLine(prefLine);

    }

}
