package oit.is.z0744.kaizi.janken.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import oit.is.z0744.kaizi.janken.model.Entry;

@Controller
public class Lec02Controller {

  @Autowired
  private Entry room;

  /**
   *
   * @return
   */

   /**
   *
   * @param model Thymeleafにわたすデータを保持するオブジェクト
   * @param prin  ログインユーザ情報が保持されるオブジェクト
   * @return
   */
  @GetMapping("/lec02/step1")
  public String lec02(Principal prin, ModelMap model) {
    String loginUser = prin.getName();
    this.room.addUser(loginUser);
    model.addAttribute("room", this.room);

    return "lec02.html";
  }
  /**
   * @param namae
   * @return
   */
  /*
   * @PostMapping("/lec02") public String lec02(@RequestParam String namae,
   * ModelMap model) { model.addAttribute("namae", namae); return "lec02.html"; }
   */

  @GetMapping("/gu")
  public String gu() {
    return "lec02.html";
  }

  /**
   * @param param
   * @return
   */
  @GetMapping("/jan/{param}")
  public String jan(@PathVariable String param, ModelMap model) {
    int tasu = Integer.parseInt(param);

    if (tasu == 1) {
      model.addAttribute("te", "Gu");
      model.addAttribute("syouhai", "draw");
    } else if (tasu == 2) {
      model.addAttribute("te", "Tyoki");
      model.addAttribute("syouhai", "You Lose");
    } else if (tasu == 3) {
      model.addAttribute("te", "Pa");
      model.addAttribute("syouhai", "You Win");
    }

    return "lec02.html";
  }

  /**
   *
   * @param model Thymeleafにわたすデータを保持するオブジェクト
   * @param prin  ログインユーザ情報が保持されるオブジェクト
   * @return
   */



}
