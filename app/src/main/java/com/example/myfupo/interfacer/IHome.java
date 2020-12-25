package com.example.myfupo.interfacer;


import com.example.myfupo.base.Item;

public interface IHome {
    interface View {
        void getItem(Item item);
    }
    interface Persenter{
        void getItem();

    }
    interface Mdelo{
        void getMdelo1(Classback classback);
    }
}
