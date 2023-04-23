/**
*
* @author Rafet ERSOY    rafet.ersoy@ogr.sakarya.edu.tr
* @since 21.04.2023
* <p>
* FunctionManagerTest sınıfımın test sınıfıdır
* </p>
*/

package pkt.business.function;

import org.junit.jupiter.api.DisplayName;

import pkt.business.AbstractManagerTest;
import pkt.business.abstracts.function.FunctionService;
import pkt.business.concretes.function.FunctionManager;

@DisplayName("Function Manager Test")
class FunctionManagerTest extends AbstractManagerTest<FunctionService> {

    @Override
    public FunctionService getServiceInstance() {
        return new FunctionManager(regexService);
    }

    @Override
    public int calculate(String expression) {
        return service.calculate(expression);
    }
}