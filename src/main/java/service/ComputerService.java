package service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.google.protobuf.Option;

import dao.ComputerDao;
import dto.ComputerDto;
import mapper.ComputerMapper;
import model.Computer;

@Service
public class ComputerService {
	private ComputerDao computerDao;
	private ComputerMapper computerMapper;

	public ComputerService(ComputerDao computerDao,ComputerMapper computerMapper) {
		this.computerDao = computerDao;
		this.computerMapper = computerMapper;
	}

	@Transactional
	public void create(Computer computer) {
		computerDao.create(computer);
	}

	@Transactional
	public void delete(int id) {
		computerDao.delete(id);
	}

	@Transactional
	public void update(Computer comp) {
		computerDao.update(comp);
	}

	@Transactional
	public List<ComputerDto> readAll() {
		return converttoDTOwithMap(computerDao.readAll());
				
	}

	@Transactional
	public Optional<ComputerDto> find(int id) {
		Optional<ComputerDto> Optionalcomputer = Optional.empty();
		Optionalcomputer = Optional.of(computerMapper.computerToComputerDto(computerDao.find(id).get()));
		return  Optionalcomputer;
	}

	@Transactional
	public List<Computer> getPageComputer(int offset, int number, String orderBy) {
		return computerDao.getPageComputer(offset, number, orderBy);
	}

	@Transactional
	public List<Computer> findName(String name, int offset, int number, String orderBy) {
		return computerDao.findName(name, offset, number, orderBy);
	}

	@Transactional
	public void deleteAllComputerSelected(List<Integer> idList) {
		computerDao.deleteAllComputerSelected(idList);
	}

	@Transactional
	public int getlength() {
		return this.readAll().size();
	}
	
	private List<ComputerDto> converttoDTOwithMap(List<Computer> listComputer) {
		return listComputer.stream()
		.map(computer -> computerMapper.computerToComputerDto(computer))
		.collect(Collectors.toList());
	}
}
