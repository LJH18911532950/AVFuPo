package com.example.myfupo.personter;


import com.example.myfupo.Mdelo.RecommendModel;
import com.example.myfupo.base.Item;
import com.example.myfupo.interfacer.Classback;
import com.example.myfupo.interfacer.IHome;

public class RecommendPersenter implements IHome.Persenter {
    IHome.View view;
    IHome.Mdelo mdelo;

    public RecommendPersenter(IHome.View view) {
        this.view = view;
        this.mdelo =new RecommendModel();
    }

    @Override
    public void getItem() {
        mdelo.getMdelo1(new Classback() {
            @Override
            public void onSecc(Object o) {
                view.getItem((Item) o);
            }

            @Override
            public void onFrom(String msg) {

            }
        });

    }


}
