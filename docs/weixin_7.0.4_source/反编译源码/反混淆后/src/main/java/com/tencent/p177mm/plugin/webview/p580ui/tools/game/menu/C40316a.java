package com.tencent.p177mm.plugin.webview.p580ui.tools.game.menu;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.plugin.webview.p580ui.tools.game.menu.C40318c.C22980a;
import com.tencent.p177mm.protocal.protobuf.bbb;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import java.util.LinkedList;
import java.util.List;

/* renamed from: com.tencent.mm.plugin.webview.ui.tools.game.menu.a */
public final class C40316a {
    public static final List<bbb> uEt = new LinkedList();

    static {
        AppMethodBeat.m2504i(8804);
        bbb bbb = new bbb();
        bbb.Title = C4996ah.getResources().getString(C25738R.string.c6x);
        bbb.ThumbUrl = "game_menu_icon_share_to_friend";
        bbb.wFR = 1;
        bbb.wFQ = 1;
        bbb.wkB = C22980a.HVGAME_MENU_ACTION_SHARE_TO_FRIEND.code;
        uEt.add(bbb);
        bbb = new bbb();
        bbb.Title = C4996ah.getResources().getString(C25738R.string.c6v);
        bbb.ThumbUrl = "game_menu_icon_exit";
        bbb.wFR = 2;
        bbb.wFQ = 2;
        bbb.wkB = C22980a.HVGAME_MENU_ACTION_EXIT.code;
        uEt.add(bbb);
        bbb = new bbb();
        bbb.Title = C4996ah.getResources().getString(C25738R.string.c6w);
        bbb.ThumbUrl = "game_menu_icon_refresh";
        bbb.wFR = 4;
        bbb.wFQ = 5;
        bbb.wkB = C22980a.HVGAME_MENU_ACTION_REFRESH.code;
        uEt.add(bbb);
        bbb = new bbb();
        bbb.Title = C4996ah.getResources().getString(C25738R.string.c6t);
        bbb.ThumbUrl = "game_menu_icon_collect";
        bbb.wFR = 3;
        bbb.wFQ = 6;
        bbb.wkB = C22980a.HVGAME_MENU_ACTION_COLLECT.code;
        uEt.add(bbb);
        bbb = new bbb();
        bbb.Title = C4996ah.getResources().getString(C25738R.string.c6u);
        bbb.ThumbUrl = "game_menu_icon_complaint";
        bbb.wFR = 6;
        bbb.wFQ = 7;
        bbb.wkB = C22980a.HVGAME_MENU_ACTION_COMPLAINT.code;
        uEt.add(bbb);
        bbb = new bbb();
        bbb.Title = C4996ah.getResources().getString(C25738R.string.c6s);
        bbb.ThumbUrl = "game_menu_icon_add_to_desktop";
        bbb.wFR = 5;
        bbb.wFQ = 8;
        bbb.wkB = C22980a.HVGAME_MENU_ACTION_ADD_TO_DESKTOP.code;
        uEt.add(bbb);
        AppMethodBeat.m2505o(8804);
    }
}
