package cl.matiasaraya.tddworkshop.service.impl;

import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;
import org.junit.runner.RunWith;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Before;
import org.junit.Test;
import org.springframework.test.context.ActiveProfiles;

import cl.matiasaraya.tddworkshop.elements.Loan;

@RunWith(MockitoJUnitRunner.class)
@ActiveProfiles("test")
public class LoanDefaultRulesServiceImplTest {
	
	@InjectMocks
	LoanDefaultRulesServiceImpl loanDefaultRulesServiceImpl;
	
	private Loan loan;
	
	@Before
	public void init() {
		loan = new Loan();
	}
	
	@Test
	public void isInDefaultForDaysPastDueHipotecario91Test(){
		loan.setDaysPastDue(91);
		loan.setType("hipotecario");		
		
		assertThat(loanDefaultRulesServiceImpl.isInDefaultForDaysPastDue(loan)).isFalse();
	}
	
	@Test
	public void isInDefaultForDaysPastDueHipotecario121Test(){
		loan.setDaysPastDue(121);
		loan.setType("hipotecario");		
		
		assertThat(loanDefaultRulesServiceImpl.isInDefaultForDaysPastDue(loan)).isTrue();
	}
	
	@Test
	public void isInDefaultForDaysPastDueConsumo91Test(){
		loan.setDaysPastDue(91);
		loan.setType("consumo");
		
		assertThat(loanDefaultRulesServiceImpl.isInDefaultForDaysPastDue(loan)).isTrue();
	}
	
	@Test
	public void isInDefaultForDaysPastDueConsumo90Test(){
		loan.setDaysPastDue(90);
		loan.setType("consumo");
		
		assertThat(loanDefaultRulesServiceImpl.isInDefaultForDaysPastDue(loan)).isFalse();
	}

}
