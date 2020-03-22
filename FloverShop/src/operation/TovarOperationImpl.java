
package operation;
import java.util.ArrayList;

import java.util.List;

import types.Tovar;
public class TovarOperationImpl implements TovarOperation{
    static List<Tovar> lstTovar = new ArrayList<Tovar>();


@Override

public List<Tovar> getListOfTovar(){

return lstTovar;

}

@Override

public List<Tovar> addNewTovar(Tovar item){

lstTovar.add(item);

return lstTovar;

}

@Override

public int getSumOfTovar(){

int sum = 0;

for(Tovar tovar: lstTovar)

sum += tovar.getKol() * tovar.getPrice();

return sum;

}
}
