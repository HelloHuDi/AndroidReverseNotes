package com.tencent.mm.pluginsdk.model;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelstat.a.a;
import com.tencent.mm.plugin.fav.PluginFav;
import com.tencent.mm.plugin.fav.a.ae;
import com.tencent.mm.plugin.fav.a.g;
import com.tencent.mm.plugin.report.e;
import com.tencent.mm.sdk.platformtools.ab;

public class d implements a {
    public final void callback(Bundle bundle) {
        int i;
        AppMethodBeat.i(27236);
        int i2 = bundle.getInt("mm_rpt_fav_id", 0);
        int i3 = bundle.getInt("key_detail_fav_scene", 0);
        int i4 = bundle.getInt("key_detail_fav_sub_scene", 0);
        int i5 = bundle.getInt("key_detail_fav_index", 0);
        long j = bundle.getLong("key_activity_browse_time", -1);
        int i6 = bundle.getBoolean("mm_scroll_bottom") ? 1 : 0;
        int i7 = bundle.getInt("mm_send_friend_count", 0);
        int i8 = bundle.getInt("mm_share_sns_count", 0);
        if (bundle.getBoolean("mm_del_fav", false)) {
            i = 1;
        } else {
            i = 0;
        }
        int i9 = bundle.getInt("mm_edit_fav_count", 0);
        String string = bundle.getString("key_detail_fav_query", "");
        String string2 = bundle.getString("key_detail_fav_sessionid", "");
        String string3 = bundle.getString("key_detail_fav_tags", "");
        ab.d("MicroMsg.FavWebRptCallback", "FavWebRptCallback uiBrowseTime[%d] isScrollBottom[%b] sendToFriendCount[%d] shareSnsCount[%d]  isDelFav[%b] clickEditFavTagCount[%d] favId[%s]", Long.valueOf(j), Integer.valueOf(i6), Integer.valueOf(i7), Integer.valueOf(i8), Integer.valueOf(i), Integer.valueOf(i9), Integer.valueOf(i2));
        g iF = ((ae) com.tencent.mm.kernel.g.M(ae.class)).getFavItemInfoStorage().iF((long) i2);
        if (iF == null) {
            ab.w("MicroMsg.FavWebRptCallback", "fav web rpt but favitem info is null favid[%d]", Integer.valueOf(i2));
            AppMethodBeat.o(27236);
            return;
        }
        long j2 = iF.field_sourceCreateTime != 0 ? iF.field_sourceCreateTime / 1000 : iF.field_updateTime / 1000;
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(i3).append(",");
        stringBuffer.append(i5).append(",");
        stringBuffer.append(i2).append(",");
        stringBuffer.append(iF.field_type).append(",");
        stringBuffer.append("0,");
        stringBuffer.append(iF.field_sourceType).append(",");
        stringBuffer.append(j2).append(",");
        stringBuffer.append(j).append(",");
        stringBuffer.append("0,");
        stringBuffer.append("0,");
        stringBuffer.append("0,");
        stringBuffer.append(i7).append(",");
        stringBuffer.append(i8).append(",");
        stringBuffer.append("0,");
        stringBuffer.append(i9).append(",");
        stringBuffer.append(i).append(",");
        stringBuffer.append(i6).append(",");
        stringBuffer.append(i4).append(",");
        stringBuffer.append(string2).append(",");
        stringBuffer.append(((PluginFav) com.tencent.mm.kernel.g.M(PluginFav.class)).getFavItemInfoStorage().vz(i2) + 1).append(",");
        stringBuffer.append(string).append(",");
        stringBuffer.append(string3);
        ab.d("MicroMsg.FavWebRptCallback", String.format("lxl, 15098, sid:%s, sourcepos:%s, query:%s, tag:%s", new Object[]{string2, Integer.valueOf(r2), string, string3}));
        ab.v("MicroMsg.FavWebRptCallback", "FavWebRptCallback rpt id[%d] [%s]", Integer.valueOf(15098), stringBuffer.toString());
        e.pXa.X(15098, stringBuffer.toString());
        AppMethodBeat.o(27236);
    }
}
