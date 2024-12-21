package iuh.fit.se.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;

import iuh.fit.se.entities.CuaHang;
import iuh.fit.se.entities.DonHang;
import iuh.fit.se.services.CuaHangService;
import iuh.fit.se.services.DonHangService;
import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
@RequestMapping("/donhang")
public class DonHangController {
	@Autowired
	private CuaHangService cuaHangService;
	@Autowired
	private DonHangService donHangService;

	@GetMapping("")
	public String getMethodName(Model model) {
		model.addAttribute("listDonHang", donHangService.findAll());
		return "list";
	}

	@GetMapping("/search")
	public String timKiem(@RequestParam(name = "maDH") String maDH, @RequestParam(name = "ten") String TenCH,
			Model model) {
		model.addAttribute("listDonHang", donHangService.findByMaDHorTenCH("%" + maDH + "%", "%" + TenCH + "%"));
		return "list";
	}

	@GetMapping("/add")
	public String showFormAddDH(Model model) {
		List<CuaHang> cuaHangList = cuaHangService.findAll();
		model.addAttribute("donHang", new DonHang());
		model.addAttribute("cuaHangList", cuaHangList);
		return "save";
	}

	@GetMapping("/update/{id}")
	public String showUpdateForm(@PathVariable("id") Integer id, Model model) {
		DonHang donHang = donHangService.findByID(id);
		List<CuaHang> cuaHangList = cuaHangService.findAll();
		model.addAttribute("donHang", donHang);
		model.addAttribute("cuaHangList", cuaHangList);
		return "save";
	}

	@PostMapping("/update/{id}")
	public String postMethodName(@PathVariable("id") Integer id, @ModelAttribute("donHang") @Valid DonHang donHang,
			BindingResult bindingResult, Model model) {
		if (bindingResult.hasErrors()) {
			List<CuaHang> cuaHangList = cuaHangService.findAll();
			model.addAttribute("cuaHangList", cuaHangList);
			return "save";
		}
		if (id != 0) {
			donHang.setId(id);
		}
		donHangService.save(donHang);
		return "redirect:/donhang";
	}

	@PostMapping("/delete/{id}")
	public String postMethodName(@PathVariable("id") Integer id) {
		donHangService.delete(id);
		return "redirect:/donhang";
	}
	
}
