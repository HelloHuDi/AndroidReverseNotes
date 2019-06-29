.class public final La/b/c/g/f;
.super Ljava/lang/Object;
.source ""


# direct methods
.method public static a(II)I
    .locals 2
    .param p0, "gravity"    # I
    .param p1, "layoutDirection"    # I

    .line 145
    sget v0, Landroid/os/Build$VERSION;->SDK_INT:I

    const/16 v1, 0x11

    if-lt v0, v1, :cond_0

    .line 146
    invoke-static {p0, p1}, Landroid/view/Gravity;->getAbsoluteGravity(II)I

    move-result v0

    return v0

    .line 149
    :cond_0
    const v0, -0x800001

    and-int/2addr v0, p0

    return v0
.end method
