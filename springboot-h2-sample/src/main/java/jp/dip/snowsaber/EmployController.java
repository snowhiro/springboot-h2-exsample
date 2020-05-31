package jp.dip.snowsaber;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jp.dip.snowsaber.dao.EmployDao;
import jp.dip.snowsaber.dto.Employ;

@RestController
public class EmployController {

	@Autowired
	private EmployDao employDao;


	@RequestMapping("/employ-list")
	public List<Employ> index() throws Exception {
		List<Employ> list = employDao.findAll();
		return list;
	}
}
