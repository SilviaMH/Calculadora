package mx.ipn.cic.calculadora_b19;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;

public class PageViewModel extends ViewModel {
    private MutableLiveData<String> mName = new MutableLiveData<>();

    public void setName (String name) {
        mName.setValue(name);
    }

    public LiveData<String> getName() {
        return mName;
    }
}
