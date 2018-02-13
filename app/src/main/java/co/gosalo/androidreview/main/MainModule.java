package co.gosalo.androidreview.main;

import android.content.Context;

import co.gosalo.androidreview.app.api.GosaloService;
import co.gosalo.androidreview.main.mvp.MainModel;
import co.gosalo.androidreview.main.mvp.MainPresenter;
import co.gosalo.androidreview.main.mvp.view.MainView;
import dagger.Module;
import dagger.Provides;

/**
 * Created by jorge on 12/02/2018.
 */

@Module
public class MainModule {

    private final Context context;

    public MainModule(Context context) {
        this.context = context;
    }

    @MainScope
    @Provides
    public MainModel provideMainModel(GosaloService service) {
        return new MainModel(service);
    }

    @MainScope
    @Provides
    public MainView provideMainView() {
        return new MainView(context);
    }

    @MainScope
    @Provides
    public MainPresenter provideMainPresenter(MainModel mainModel, MainView mainView) {
        return new MainPresenter(mainModel, mainView);
    }
}
