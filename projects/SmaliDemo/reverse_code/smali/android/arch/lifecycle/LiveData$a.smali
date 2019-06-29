.class abstract Landroid/arch/lifecycle/LiveData$a;
.super Ljava/lang/Object;
.source ""


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Landroid/arch/lifecycle/LiveData;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x402
    name = "a"
.end annotation


# instance fields
.field final a:Landroid/arch/lifecycle/n;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Landroid/arch/lifecycle/n<",
            "TT;>;"
        }
    .end annotation
.end field

.field b:Z

.field c:I

.field final synthetic d:Landroid/arch/lifecycle/LiveData;


# direct methods
.method constructor <init>(Landroid/arch/lifecycle/LiveData;Landroid/arch/lifecycle/n;)V
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroid/arch/lifecycle/n<",
            "TT;>;)V"
        }
    .end annotation

    .line 387
    .local p0, "this":Landroid/arch/lifecycle/LiveData$a;, "Landroid/arch/lifecycle/LiveData<TT;>.ObserverWrapper;"
    .local p2, "observer":Landroid/arch/lifecycle/n;, "Landroid/arch/lifecycle/Observer<TT;>;"
    iput-object p1, p0, Landroid/arch/lifecycle/LiveData$a;->d:Landroid/arch/lifecycle/LiveData;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 385
    const/4 p1, -0x1

    iput p1, p0, Landroid/arch/lifecycle/LiveData$a;->c:I

    .line 388
    iput-object p2, p0, Landroid/arch/lifecycle/LiveData$a;->a:Landroid/arch/lifecycle/n;

    .line 389
    return-void
.end method


# virtual methods
.method a()V
    .locals 0

    .line 398
    .local p0, "this":Landroid/arch/lifecycle/LiveData$a;, "Landroid/arch/lifecycle/LiveData<TT;>.ObserverWrapper;"
    return-void
.end method

.method a(Z)V
    .locals 5
    .param p1, "newActive"    # Z

    .line 401
    .local p0, "this":Landroid/arch/lifecycle/LiveData$a;, "Landroid/arch/lifecycle/LiveData<TT;>.ObserverWrapper;"
    iget-boolean v0, p0, Landroid/arch/lifecycle/LiveData$a;->b:Z

    if-ne p1, v0, :cond_0

    .line 402
    return-void

    .line 406
    :cond_0
    iput-boolean p1, p0, Landroid/arch/lifecycle/LiveData$a;->b:Z

    .line 407
    iget-object v0, p0, Landroid/arch/lifecycle/LiveData$a;->d:Landroid/arch/lifecycle/LiveData;

    invoke-static {v0}, Landroid/arch/lifecycle/LiveData;->c(Landroid/arch/lifecycle/LiveData;)I

    move-result v0

    const/4 v1, 0x1

    if-nez v0, :cond_1

    const/4 v0, 0x1

    goto :goto_0

    :cond_1
    const/4 v0, 0x0

    .line 408
    .local v0, "wasInactive":Z
    :goto_0
    iget-object v2, p0, Landroid/arch/lifecycle/LiveData$a;->d:Landroid/arch/lifecycle/LiveData;

    invoke-static {v2}, Landroid/arch/lifecycle/LiveData;->c(Landroid/arch/lifecycle/LiveData;)I

    move-result v3

    iget-boolean v4, p0, Landroid/arch/lifecycle/LiveData$a;->b:Z

    if-eqz v4, :cond_2

    goto :goto_1

    :cond_2
    const/4 v1, -0x1

    :goto_1
    add-int/2addr v3, v1

    invoke-static {v2, v3}, Landroid/arch/lifecycle/LiveData;->a(Landroid/arch/lifecycle/LiveData;I)I

    .line 409
    if-eqz v0, :cond_3

    iget-boolean v1, p0, Landroid/arch/lifecycle/LiveData$a;->b:Z

    if-eqz v1, :cond_3

    .line 410
    iget-object v1, p0, Landroid/arch/lifecycle/LiveData$a;->d:Landroid/arch/lifecycle/LiveData;

    invoke-virtual {v1}, Landroid/arch/lifecycle/LiveData;->b()V

    .line 412
    :cond_3
    iget-object v1, p0, Landroid/arch/lifecycle/LiveData$a;->d:Landroid/arch/lifecycle/LiveData;

    invoke-static {v1}, Landroid/arch/lifecycle/LiveData;->c(Landroid/arch/lifecycle/LiveData;)I

    move-result v1

    if-nez v1, :cond_4

    iget-boolean v1, p0, Landroid/arch/lifecycle/LiveData$a;->b:Z

    if-nez v1, :cond_4

    .line 413
    iget-object v1, p0, Landroid/arch/lifecycle/LiveData$a;->d:Landroid/arch/lifecycle/LiveData;

    invoke-virtual {v1}, Landroid/arch/lifecycle/LiveData;->c()V

    .line 415
    :cond_4
    iget-boolean v1, p0, Landroid/arch/lifecycle/LiveData$a;->b:Z

    if-eqz v1, :cond_5

    .line 416
    iget-object v1, p0, Landroid/arch/lifecycle/LiveData$a;->d:Landroid/arch/lifecycle/LiveData;

    invoke-static {v1, p0}, Landroid/arch/lifecycle/LiveData;->a(Landroid/arch/lifecycle/LiveData;Landroid/arch/lifecycle/LiveData$a;)V

    .line 418
    :cond_5
    return-void
.end method

.method a(Landroid/arch/lifecycle/f;)Z
    .locals 1
    .param p1, "owner"    # Landroid/arch/lifecycle/f;

    .line 394
    .local p0, "this":Landroid/arch/lifecycle/LiveData$a;, "Landroid/arch/lifecycle/LiveData<TT;>.ObserverWrapper;"
    const/4 v0, 0x0

    return v0
.end method

.method abstract b()Z
.end method
