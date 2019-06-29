.class public Landroid/arch/lifecycle/m;
.super Landroid/arch/lifecycle/LiveData;
.source ""


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "<T:",
        "Ljava/lang/Object;",
        ">",
        "Landroid/arch/lifecycle/LiveData<",
        "TT;>;"
    }
.end annotation


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 25
    .local p0, "this":Landroid/arch/lifecycle/m;, "Landroid/arch/lifecycle/MutableLiveData<TT;>;"
    invoke-direct {p0}, Landroid/arch/lifecycle/LiveData;-><init>()V

    return-void
.end method


# virtual methods
.method public a(Ljava/lang/Object;)V
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(TT;)V"
        }
    .end annotation

    .line 33
    .local p0, "this":Landroid/arch/lifecycle/m;, "Landroid/arch/lifecycle/MutableLiveData<TT;>;"
    .local p1, "value":Ljava/lang/Object;, "TT;"
    invoke-super {p0, p1}, Landroid/arch/lifecycle/LiveData;->a(Ljava/lang/Object;)V

    .line 34
    return-void
.end method
