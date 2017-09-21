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
	 * ��̨��ʾƷ�ƽ���
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
	 * ���Ʒ��
	 */

	public String addBrand() throws Exception {
		try {
			b.addBrand(brand);
			request.setAttribute("msg", " ��ӳɹ���");
			return "brandList";

		} catch (Exception e) {
			// TODO: handle exception
		}
		return "error";
	}

	/*
	 * �޸�Ʒ��
	 */

	public String modifyBrand() throws Exception {
		try {
			if (brand != null) {
				b.modifyBrand(brand);
				request.setAttribute("msg", "�޸ĳɹ���");
				return "brandList";

			} else {
				request.setAttribute("msg", "�޸�ʧ�ܣ�");
				return "brandList";
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return "error";
	}

	/*
	 * ɾ��Ʒ��
	 */

	public String deleteBrand() throws Exception {
		try {
			brand = b.getBrand(brand.getBrand_id());
			if (brand != null) {
				b.deleteBrand(brand);
				request.setAttribute("msg", "ɾ���ɹ���");
				return "brandList";
			} else {
				request.setAttribute("msg", "�Ҳ���");
				return "brandList";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "error";
	}

	/*
	 * ��̨��ʾ����������
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
	 * ��Ӵ�����
	 */

	public String addCpu() throws Exception {
		try {
			c.addCpu(cpu);
			request.setAttribute("msg", " ��ӳɹ���");
			return "cpuList";

		} catch (Exception e) {
			// TODO: handle exception
		}
		return "error";
	}

	/*
	 * �޸Ĵ�����
	 */

	public String modifyCpu() throws Exception {
		try {
			if (cpu != null) {
				c.modifyCpu(cpu);
				request.setAttribute("msg", "�޸ĳɹ���");
				return "cpuList";
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return "error";
	}

	/*
	 * ɾ��������
	 */

	public String deleteCpu() throws Exception {
		try {
			cpu = c.getCpu(cpu.getCpu_id());
			if (cpu != null) {
				c.deleteCpu(cpu);
				request.setAttribute("msg", "ɾ���ɹ���");
				return "cpuList";
			} else {
				request.setAttribute("msg", "�Ҳ���");
				return "cpuList";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "error";
	}

	/*
	 * ��̨��ʾ��Ļ�ߴ����
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
	 * �����Ļ�ߴ�
	 */

	public String addScreen() throws Exception {
		try {
			s.addScreen(screen);
			request.setAttribute("msg", " ��ӳɹ���");
			return "screenList";

		} catch (Exception e) {
			// TODO: handle exception
		}
		return "error";
	}

	/*
	 * �޸���Ļ�ߴ�
	 */

	public String modifyScreen() throws Exception {
		try {
			if (screen != null) {
				s.modifyScreen(screen);
				request.setAttribute("msg", "�޸ĳɹ���");
				return "screenList";

			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return "error";
	}

	/*
	 * ɾ����Ļ�ߴ�
	 */

	public String deleteScreen() throws Exception {
		try {
			screen = s.getScreen(screen.getScreen_id());
			if (screen != null) {
				s.deleteScreen(screen);
				request.setAttribute("msg", "ɾ���ɹ���");
				return "screenList";

			} else {
				request.setAttribute("msg", "�Ҳ���");
				return "screenList";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "error";
	}
}
