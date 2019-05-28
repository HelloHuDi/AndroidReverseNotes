package com.tencent.mm.plugin.card.model;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class n {
    public static int kdJ = 1;

    public enum a {
        NORMAL_TYPE,
        INVALID_TYPE,
        CAN_GIFT_TYPE,
        GENERAL_TYPE,
        MEMBER_CARD_TYPE,
        HOME_MEMBER_CARD_TYPE,
        GENERAL_WITHOUT_INVOICE_TYPE;

        static {
            AppMethodBeat.o(87856);
        }
    }
}
