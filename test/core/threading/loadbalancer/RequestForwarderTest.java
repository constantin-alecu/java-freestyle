package core.threading.loadbalancer;

import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.*;
import static org.junit.Assert.*;

public class RequestForwarderTest {

    @Mock
    LoadBalancer loadBalancer;

    @InjectMocks
    RequestForwarder requestForwarder;

    @Test
    public void simpleTest(){
        MockitoAnnotations.openMocks(this);
        when(loadBalancer.getIp("1234")).thenReturn("1");
        String result = requestForwarder.forwardRequest("1234");
        assertTrue(result.equals("1 was accessed"));
    }

    @Test
    public void simpleTest2(){
        MockitoAnnotations.openMocks(this);
        when(loadBalancer.getIp("1234")).thenReturn("1");
        String result = requestForwarder.forwardRequest("1234");
        assertTrue(result.equals("1 was accessed"));
    }
}
