package com.tencent.mm.plugin.webview.ui.tools.game.menu;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.protocal.protobuf.bbb;
import com.tencent.mm.sdk.platformtools.ah;
import java.util.LinkedList;
import java.util.List;

public final class a {
    public static final List<bbb> uEt = new LinkedList();

    static {
        AppMethodBeat.i(8804);
        bbb bbb = new bbb();
        bbb.Title = ah.getResources().getString(R.string.c6x);
        bbb.ThumbUrl = "game_menu_icon_share_to_friend";
        bbb.wFR = 1;
        bbb.wFQ = 1;
        bbb.wkB = com.tencent.mm.plugin.webview.ui.tools.game.menu.c.a.HVGAME_MENU_ACTION_SHARE_TO_FRIEND.code;
        uEt.add(bbb);
        bbb = new bbb();
        bbb.Title = ah.getResources().getString(R.string.c6v);
        bbb.ThumbUrl = "game_menu_icon_exit";
        bbb.wFR = 2;
        bbb.wFQ = 2;
        bbb.wkB = com.tencent.mm.plugin.webview.ui.tools.game.menu.c.a.HVGAME_MENU_ACTION_EXIT.code;
        uEt.add(bbb);
        bbb = new bbb();
        bbb.Title = ah.getResources().getString(R.string.c6w);
        bbb.ThumbUrl = "game_menu_icon_refresh";
        bbb.wFR = 4;
        bbb.wFQ = 5;
        bbb.wkB = com.tencent.mm.plugin.webview.ui.tools.game.menu.c.a.HVGAME_MENU_ACTION_REFRESH.code;
        uEt.add(bbb);
        bbb = new bbb();
        bbb.Title = ah.getResources().getString(R.string.c6t);
        bbb.ThumbUrl = "game_menu_icon_collect";
        bbb.wFR = 3;
        bbb.wFQ = 6;
        bbb.wkB = com.tencent.mm.plugin.webview.ui.tools.game.menu.c.a.HVGAME_MENU_ACTION_COLLECT.code;
        uEt.add(bbb);
        bbb = new bbb();
        bbb.Title = ah.getResources().getString(R.string.c6u);
        bbb.ThumbUrl = "game_menu_icon_complaint";
        bbb.wFR = 6;
        bbb.wFQ = 7;
        bbb.wkB = com.tencent.mm.plugin.webview.ui.tools.game.menu.c.a.HVGAME_MENU_ACTION_COMPLAINT.code;
        uEt.add(bbb);
        bbb = new bbb();
        bbb.Title = ah.getResources().getString(R.string.c6s);
        bbb.ThumbUrl = "game_menu_icon_add_to_desktop";
        bbb.wFR = 5;
        bbb.wFQ = 8;
        bbb.wkB = com.tencent.mm.plugin.webview.ui.tools.game.menu.c.a.HVGAME_MENU_ACTION_ADD_TO_DESKTOP.code;
        uEt.add(bbb);
        AppMethodBeat.o(8804);
    }
}
