package com.action;

import java.util.List;

import com.zmm.pojo.Brand;
import com.zmm.pojo.Cpu;
import com.zmm.pojo.Screen;
import com.zmm.service.BrandService;
import com.zmm.service.CpuService;
import com.zmm.service.ScreenService;

public class CategoryAction extends BaseAction {

	BrandService b = new BrandService();
	CpuService c = new CpuService();
	ScreenService s = new ScreenService();
	private Brand brand;
	private Screen screen;
	private Cpu cpu;

	public Brand getBrand() {
		return brand;
	}

	public void setBrand(Brand brand) {
		this.brand = brand;
	}

	public Screen getScreen() {
		return screen;
	}

	public void setScreen(Screen screen) {
		this.screen = screen;
	}

	public Cpu getCpu() {
		return cpu;
	}

	public void setCpu(Cpu cpu) {
		this.cpu = cpu;
	}

	/*
	 * 后台显示品牌界面
	 */
	public String listBrand() throws Exception {
		try {
			List<Brand> brandList = b.listBrand();
			request.setAttribute("bList", brandList);
			return "blist";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "error";
	}

	/*
	 * 添加品牌
	 */

	public String addBrand() throws Exception {
		try {
			b.addBrand(brand);
			request.setAttribute("msg", " 添加成功！");
			return "brandList";

		} catch (Exception e) {
			// TODO: handle exception
		}
		return "error";
	}

	/*
	 * 修改品牌
	 */

	public String modifyBrand() throws Exception {
		try {
			if (brand != null) {
				b.modifyBrand(brand);
				request.setAttribute("msg", "修改成功！");
				return "brandList";

			} else {
				request.setAttribute("msg", "修改失败！");
				return "brandList";
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return "error";
	}

	/*
	 * 删除品牌
	 */

	public String deleteBrand() throws Exception {
		try {
			brand = b.getBrand(brand.getBrand_id());
			if (brand != null) {
				b.deleteBrand(brand);
				request.setAttribute("msg", "删除成功！");
				return "brandList";
			} else {
				request.setAttribute("msg", "找不到");
				return "brandList";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "error";
	}

	/*
	 * 后台显示处理器界面
	 */
	public String listCpu() throws Exception {
		try {
			List<Cpu> cList = c.listCpu();
			request.setAttribute("cList", cList);
			return "clist";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "error";
	}

	/*
	 * 添加处理器
	 */

	public String addCpu() throws Exception {
		try {
			c.addCpu(cpu);
			request.setAttribute("msg", " 添加成功！");
			return "cpuList";

		} catch (Exception e) {
			// TODO: handle exception
		}
		return "error";
	}

	/*
	 * 修改处理器
	 */

	public String modifyCpu() throws Exception {
		try {
			if (cpu != null) {
				c.modifyCpu(cpu);
				request.setAttribute("msg", "修改成功！");
				return "cpuList";
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return "error";
	}

	/*
	 * 删除处理器
	 */

	public String deleteCpu() throws Exception {
		try {
			cpu = c.getCpu(cpu.getCpu_id());
			if (cpu != null) {
				c.deleteCpu(cpu);
				request.setAttribute("msg", "删除成功！");
				return "cpuList";
			} else {
				request.setAttribute("msg", "找不到");
				return "cpuList";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "error";
	}

	/*
	 * 后台显示屏幕尺寸界面
	 */
	public String listScreen() throws Exception {
		try {
			List<Screen> sList = s.listScreen();
			request.setAttribute("sList", sList);
			return "slist";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "error";
	}

	/*
	 * 添加屏幕尺寸
	 */

	public String addScreen() throws Exception {
		try {
			s.addScreen(screen);
			request.setAttribute("msg", " 添加成功！");
			return "screenList";

		} catch (Exception e) {
			// TODO: handle exception
		}
		return "error";
	}

	/*
	 * 修改屏幕尺寸
	 */

	public String modifyScreen() throws Exception {
		try {
			if (screen != null) {
				s.modifyScreen(screen);
				request.setAttribute("msg", "修改成功！");
				return "screenList";

			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return "error";
	}

	/*
	 * 删除屏幕尺寸
	 */

	public String deleteScreen() throws Exception {
		try {
			screen = s.getScreen(screen.getScreen_id());
			if (screen != null) {
				s.deleteScreen(screen);
				request.setAttribute("msg", "删除成功！");
				return "screenList";

			} else {
				request.setAttribute("msg", "找不到");
				return "screenList";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "error";
	}
}
