.class final Landroid/support/v7/widget/xa;
.super Ljava/lang/Object;
.source ""

# interfaces
.implements Landroid/os/Parcelable$ClassLoaderCreator;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Landroid/support/v7/widget/Toolbar$d;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x8
    name = null
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Object;",
        "Landroid/os/Parcelable$ClassLoaderCreator<",
        "Landroid/support/v7/widget/Toolbar$d;",
        ">;"
    }
.end annotation


# direct methods
.method constructor <init>()V
    .locals 0

    .line 2287
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public createFromParcel(Landroid/os/Parcel;)Landroid/support/v7/widget/Toolbar$d;
    .locals 2
    .param p1, "in"    # Landroid/os/Parcel;

    .line 2295
    new-instance v0, Landroid/support/v7/widget/Toolbar$d;

    const/4 v1, 0x0

    invoke-direct {v0, p1, v1}, Landroid/support/v7/widget/Toolbar$d;-><init>(Landroid/os/Parcel;Ljava/lang/ClassLoader;)V

    return-object v0
.end method

.method public createFromParcel(Landroid/os/Parcel;Ljava/lang/ClassLoader;)Landroid/support/v7/widget/Toolbar$d;
    .locals 1
    .param p1, "in"    # Landroid/os/Parcel;
    .param p2, "loader"    # Ljava/lang/ClassLoader;

    .line 2290
    new-instance v0, Landroid/support/v7/widget/Toolbar$d;

    invoke-direct {v0, p1, p2}, Landroid/support/v7/widget/Toolbar$d;-><init>(Landroid/os/Parcel;Ljava/lang/ClassLoader;)V

    return-object v0
.end method

.method public bridge synthetic createFromParcel(Landroid/os/Parcel;)Ljava/lang/Object;
    .locals 0

    .line 2287
    invoke-virtual {p0, p1}, Landroid/support/v7/widget/xa;->createFromParcel(Landroid/os/Parcel;)Landroid/support/v7/widget/Toolbar$d;

    move-result-object p1

    return-object p1
.end method

.method public bridge synthetic createFromParcel(Landroid/os/Parcel;Ljava/lang/ClassLoader;)Ljava/lang/Object;
    .locals 0

    .line 2287
    invoke-virtual {p0, p1, p2}, Landroid/support/v7/widget/xa;->createFromParcel(Landroid/os/Parcel;Ljava/lang/ClassLoader;)Landroid/support/v7/widget/Toolbar$d;

    move-result-object p1

    return-object p1
.end method

.method public newArray(I)[Landroid/support/v7/widget/Toolbar$d;
    .locals 1
    .param p1, "size"    # I

    .line 2300
    new-array v0, p1, [Landroid/support/v7/widget/Toolbar$d;

    return-object v0
.end method

.method public bridge synthetic newArray(I)[Ljava/lang/Object;
    .locals 0

    .line 2287
    invoke-virtual {p0, p1}, Landroid/support/v7/widget/xa;->newArray(I)[Landroid/support/v7/widget/Toolbar$d;

    move-result-object p1

    return-object p1
.end method
