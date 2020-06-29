package cl.matiasaraya.tddworkshop.service;

import cl.matiasaraya.tddworkshop.elements.Loan;

public interface LoanDefaultRulesService {
	
	public boolean isInDefaultForDaysPastDue(Loan loan);

}
