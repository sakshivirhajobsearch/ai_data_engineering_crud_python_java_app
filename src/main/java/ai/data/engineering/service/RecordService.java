package ai.data.engineering.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ai.data.engineering.model.RecordEntity;
import ai.data.engineering.repository.RecordRepository;

import java.util.List;
import java.util.Optional;

@Service
public class RecordService {

	@Autowired
	private RecordRepository recordRepository;

	public List<RecordEntity> getAllRecords() {
		return recordRepository.findAll();
	}

	public RecordEntity getById(int id) {
		Optional<RecordEntity> record = recordRepository.findById(id);
		return record.orElse(null);
	}

	public RecordEntity create(RecordEntity record) {
		return recordRepository.save(record);
	}

	public RecordEntity update(int id, RecordEntity record) {
		RecordEntity existing = getById(id);
		if (existing != null) {
			existing.setName(record.getName());
			existing.setAge(record.getAge());
			return recordRepository.save(existing);
		} else {
			return null;
		}
	}

	public void delete(int id) {
		recordRepository.deleteById(id);
	}
}