package com.tencent.p177mm.p612ui;

/* renamed from: com.tencent.mm.ui.c */
public interface C5301c {

    /* renamed from: com.tencent.mm.ui.c$a */
    public interface C5302a {
        void onTabClick(int i);
    }

    /* renamed from: MM */
    void mo10902MM(int i);

    /* renamed from: MN */
    void mo10903MN(int i);

    /* renamed from: MO */
    void mo10904MO(int i);

    /* renamed from: MP */
    void mo10905MP(int i);

    void dwp();

    int getContactTabUnread();

    int getCurIdx();

    int getFriendTabUnread();

    int getMainTabUnread();

    boolean getSettingsPoint();

    int getSettingsTabUnread();

    boolean getShowFriendPoint();

    /* renamed from: l */
    void mo10914l(int i, float f);

    /* renamed from: px */
    void mo10915px(boolean z);

    /* renamed from: py */
    void mo10916py(boolean z);

    /* renamed from: pz */
    void mo10917pz(boolean z);

    void setOnTabClickListener(C5302a c5302a);

    void setTo(int i);
}
