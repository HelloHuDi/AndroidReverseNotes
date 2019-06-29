.class public La/b/c/f/k;
.super Ljava/lang/Object;
.source ""


# direct methods
.method public static varargs a([Ljava/lang/Object;)I
    .locals 2
    .param p0, "values"    # [Ljava/lang/Object;

    .line 92
    sget v0, Landroid/os/Build$VERSION;->SDK_INT:I

    const/16 v1, 0x13

    if-lt v0, v1, :cond_0

    .line 93
    invoke-static {p0}, Ljava/util/Objects;->hash([Ljava/lang/Object;)I

    move-result v0

    return v0

    .line 95
    :cond_0
    invoke-static {p0}, Ljava/util/Arrays;->hashCode([Ljava/lang/Object;)I

    move-result v0

    return v0
.end method
