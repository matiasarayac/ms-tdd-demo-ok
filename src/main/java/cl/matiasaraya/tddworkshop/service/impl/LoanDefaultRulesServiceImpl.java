package cl.matiasaraya.tddworkshop.service.impl;

import org.springframework.stereotype.Service;

import cl.matiasaraya.tddworkshop.elements.Loan;
import cl.matiasaraya.tddworkshop.service.LoanDefaultRulesService;

@Service("loanDefaultService")
public class LoanDefaultRulesServiceImpl implements LoanDefaultRulesService {

	@Override
	public boolean isInDefaultForDaysPastDue(Loan loan) {
		if("hipotecario".equals(loan.getType())) {
			if(loan.getDaysPastDue() > 120) {
				return true;
			}
		} else {
			if(loan.getDaysPastDue() > 90) {
				return true;
			}
		}
		
		return false;
	}

}
