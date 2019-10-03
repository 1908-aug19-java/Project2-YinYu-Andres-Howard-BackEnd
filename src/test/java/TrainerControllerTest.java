import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;


import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;

import com.revature.controllers.TrainerController;
import com.revature.models.Pokemon;
import com.revature.models.Trainer;
import com.revature.services.TrainerService;


public class TrainerControllerTest {

	
	 @InjectMocks
	    private TrainerController trainerController;

	    @Mock
		private TrainerService trainerService;	

	    @Before
	    public void init() {
	        MockitoAnnotations.initMocks(this);
	    }
	    @Test
	    public void testFindTrainerByUsername() {
	        Trainer t = new Trainer();
	        t.setUserName("abdo123");
	        when(trainerService.findTrainerByuserName("abdo123")).thenReturn(t);
	        
	        Trainer trainer = trainerController.getTrainersByUsername("abdo123");
	        verify(trainerService).findTrainerByuserName("abdo123");
	        assertEquals("abdo123", trainer.getUserName());
	    }
	 
	    @Test
	    public void testaddTrainer() {
	        Trainer t  = new Trainer(1,"John","Mockito","passWord","StarterPokem","Johnyy123",null);
	     
	        when(trainerService.addTrainer(t)).thenReturn(t);
	        
	        ResponseEntity<Trainer> tt = trainerController.addTrainer(t);
	        System.out.println("response entity trainer adding code "+tt.getStatusCode());
	        verify(trainerService).addTrainer(t);   
	        assertEquals(201,tt.getStatusCodeValue());
	    }
	 

	
	
}
