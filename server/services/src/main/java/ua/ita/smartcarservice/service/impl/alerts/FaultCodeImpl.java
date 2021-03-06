package ua.ita.smartcarservice.service.impl.alerts;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.ita.smartcarservice.dto.alerts.FaultCodeDto;
import ua.ita.smartcarservice.entity.alerts.FaultCode;
import ua.ita.smartcarservice.repository.alerts.FaultCodeRepository;
import ua.ita.smartcarservice.service.alerts.FaultCodeService;

@Service
public class FaultCodeImpl implements FaultCodeService {

	@Autowired
	private FaultCodeRepository faultCodeRepository;

	/* READ */
	@Override
	public FaultCodeDto getFaultCode(String code) {
		return entityToDto(faultCodeRepository.getFaultCode(code));
	}

	/* convert entity to DTO */
	private FaultCodeDto entityToDto(FaultCode entity) {
		return new FaultCodeDto(entity.getFaultCode(),
				entity.getDescription(),
				entity.getSuggestion(),
				entity.getType(),
				entity.getSkill());
	}
}
