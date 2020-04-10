package com.zeeshan.dynamictabs.data;

import com.zeeshan.dynamictabs.ui.activities.MainActivity;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TabModel {

    private int tabPosition;
    private String tabName;

    public TabModel(int tabPosition, String tabName) {
        this.tabPosition = tabPosition;
        this.tabName = tabName;
    }

    public int getTabPosition() {
        return tabPosition;
    }

    public void setTabPosition(int tabPosition) {
        this.tabPosition = tabPosition;
    }

    public String getTabName() {
        return tabName;
    }

    public void setTabName(String tabName) {
        this.tabName = tabName;
    }

    public static List<TabModel> getListOfTabs() {

        List<TabModel> tabModelList = new ArrayList<>();
        tabModelList.add(new TabModel(MainActivity.A, "A"));
        tabModelList.add(new TabModel(MainActivity.B, "B"));
        tabModelList.add(new TabModel(MainActivity.C, "C"));
        tabModelList.add(new TabModel(MainActivity.D, "D"));
        tabModelList.add(new TabModel(MainActivity.E, "E"));
        tabModelList.add(new TabModel(MainActivity.F, "F"));
        tabModelList.add(new TabModel(MainActivity.G, "G"));
        tabModelList.add(new TabModel(MainActivity.H, "H"));
        tabModelList.add(new TabModel(MainActivity.I, "I"));
        tabModelList.add(new TabModel(MainActivity.J, "J"));
        tabModelList.add(new TabModel(MainActivity.K, "K"));
        tabModelList.add(new TabModel(MainActivity.L, "L"));
        tabModelList.add(new TabModel(MainActivity.M, "M"));
        tabModelList.add(new TabModel(MainActivity.N, "N"));
        tabModelList.add(new TabModel(MainActivity.O, "O"));
        tabModelList.add(new TabModel(MainActivity.P, "P"));
        tabModelList.add(new TabModel(MainActivity.O, "O"));
        tabModelList.add(new TabModel(MainActivity.P, "P"));
        tabModelList.add(new TabModel(MainActivity.Q, "Q"));
        tabModelList.add(new TabModel(MainActivity.RR, "R"));
        tabModelList.add(new TabModel(MainActivity.S, "S"));
        tabModelList.add(new TabModel(MainActivity.T, "T"));
        tabModelList.add(new TabModel(MainActivity.U, "U"));
        tabModelList.add(new TabModel(MainActivity.V, "V"));
        tabModelList.add(new TabModel(MainActivity.W, "W"));
        tabModelList.add(new TabModel(MainActivity.X, "X"));
        tabModelList.add(new TabModel(MainActivity.Y, "Y"));
        tabModelList.add(new TabModel(MainActivity.Z, "Z"));

        order(tabModelList);

        return tabModelList;
    }

    private static void order(List<TabModel> roles) {

        Collections.sort(roles, (o1, o2) -> {
            int x1 = o1.getTabPosition();
            int x2 = o2.getTabPosition();

            if (x1 != x2) {
                return x1 - x2;
            } else {
                int y1 = o1.getTabPosition();
                int y2 = o2.getTabPosition();
                return y2 - y1;
            }
        });
    }

    //        DASHBOARD
//        PROMOTIOIN
//        INVENTORY
//        INVOICES > (Unpaid, Asset, Interest)
//        STOCK > (StockList, PaidOut Stock)
//        RECEIPTS > (UAF Receipt, Receipt Details)
//        EPAYMENT
//        TERM ADJUSTMENT
//        CURTAILMENTS
//        TRAIL BALANCE
//        NEW STOCK
//        STOCK STATUS
//        CREDIT STATUS
//        SETTLEMENT STATUS
//        ASSET TRANSFER STATUS
//        PRODUCT CHANGE STATUS
//        TERM ADJUSTMENT STATUS
//        PRODUCT CHANGE STATUS
/*
        side menus:
        profile
        settings
        contact us
        logout
        notification,
        print
*/
}
