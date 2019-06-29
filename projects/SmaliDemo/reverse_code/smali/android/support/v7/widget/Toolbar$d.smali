.class public Landroid/support/v7/widget/Toolbar$d;
.super La/b/c/g/c;
.source ""


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Landroid/support/v7/widget/Toolbar;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "d"
.end annotation


# static fields
.field public static final CREATOR:Landroid/os/Parcelable$Creator;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Landroid/os/Parcelable$Creator<",
            "Landroid/support/v7/widget/Toolbar$d;",
            ">;"
        }
    .end annotation
.end field


# instance fields
.field c:I

.field d:Z


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .line 2287
    new-instance v0, Landroid/support/v7/widget/xa;

    invoke-direct {v0}, Landroid/support/v7/widget/xa;-><init>()V

    sput-object v0, Landroid/support/v7/widget/Toolbar$d;->CREATOR:Landroid/os/Parcelable$Creator;

    return-void
.end method

.method public constructor <init>(Landroid/os/Parcel;Ljava/lang/ClassLoader;)V
    .locals 1
    .param p1, "source"    # Landroid/os/Parcel;
    .param p2, "loader"    # Ljava/lang/ClassLoader;

    .line 2271
    invoke-direct {p0, p1, p2}, La/b/c/g/c;-><init>(Landroid/os/Parcel;Ljava/lang/ClassLoader;)V

    .line 2272
    invoke-virtual {p1}, Landroid/os/Parcel;->readInt()I

    move-result v0

    iput v0, p0, Landroid/support/v7/widget/Toolbar$d;->c:I

    .line 2273
    invoke-virtual {p1}, Landroid/os/Parcel;->readInt()I

    move-result v0

    if-eqz v0, :cond_0

    const/4 v0, 0x1

    goto :goto_0

    :cond_0
    const/4 v0, 0x0

    :goto_0
    iput-boolean v0, p0, Landroid/support/v7/widget/Toolbar$d;->d:Z

    .line 2274
    return-void
.end method

.method public constructor <init>(Landroid/os/Parcelable;)V
    .locals 0
    .param p1, "superState"    # Landroid/os/Parcelable;

    .line 2277
    invoke-direct {p0, p1}, La/b/c/g/c;-><init>(Landroid/os/Parcelable;)V

    .line 2278
    return-void
.end method


# virtual methods
.method public writeToParcel(Landroid/os/Parcel;I)V
    .locals 1
    .param p1, "out"    # Landroid/os/Parcel;
    .param p2, "flags"    # I

    .line 2282
    invoke-super {p0, p1, p2}, La/b/c/g/c;->writeToParcel(Landroid/os/Parcel;I)V

    .line 2283
    iget v0, p0, Landroid/support/v7/widget/Toolbar$d;->c:I

    invoke-virtual {p1, v0}, Landroid/os/Parcel;->writeInt(I)V

    .line 2284
    iget-boolean v0, p0, Landroid/support/v7/widget/Toolbar$d;->d:Z

    invoke-virtual {p1, v0}, Landroid/os/Parcel;->writeInt(I)V

    .line 2285
    return-void
.end method
