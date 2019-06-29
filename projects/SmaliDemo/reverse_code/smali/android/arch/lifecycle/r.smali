.class public Landroid/arch/lifecycle/r;
.super Ljava/lang/Object;
.source ""


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Landroid/arch/lifecycle/r$a;
    }
.end annotation


# instance fields
.field private final a:Landroid/arch/lifecycle/r$a;

.field private final b:Landroid/arch/lifecycle/s;


# direct methods
.method public constructor <init>(Landroid/arch/lifecycle/s;Landroid/arch/lifecycle/r$a;)V
    .locals 0
    .param p1, "store"    # Landroid/arch/lifecycle/s;
    .param p2, "factory"    # Landroid/arch/lifecycle/r$a;

    .line 77
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 78
    iput-object p2, p0, Landroid/arch/lifecycle/r;->a:Landroid/arch/lifecycle/r$a;

    .line 79
    iput-object p1, p0, Landroid/arch/lifecycle/r;->b:Landroid/arch/lifecycle/s;

    .line 80
    return-void
.end method


# virtual methods
.method public a(Ljava/lang/Class;)Landroid/arch/lifecycle/q;
    .locals 3
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "<T:",
            "Landroid/arch/lifecycle/q;",
            ">(",
            "Ljava/lang/Class<",
            "TT;>;)TT;"
        }
    .end annotation

    .line 98
    .local p1, "modelClass":Ljava/lang/Class;, "Ljava/lang/Class<TT;>;"
    invoke-virtual {p1}, Ljava/lang/Class;->getCanonicalName()Ljava/lang/String;

    move-result-object v0

    .line 99
    .local v0, "canonicalName":Ljava/lang/String;
    if-eqz v0, :cond_0

    .line 102
    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "android.arch.lifecycle.ViewModelProvider.DefaultKey:"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v1, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {p0, v1, p1}, Landroid/arch/lifecycle/r;->a(Ljava/lang/String;Ljava/lang/Class;)Landroid/arch/lifecycle/q;

    move-result-object v1

    return-object v1

    .line 100
    :cond_0
    new-instance v1, Ljava/lang/IllegalArgumentException;

    const-string v2, "Local and anonymous classes can not be ViewModels"

    invoke-direct {v1, v2}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v1
.end method

.method public a(Ljava/lang/String;Ljava/lang/Class;)Landroid/arch/lifecycle/q;
    .locals 2
    .param p1, "key"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "<T:",
            "Landroid/arch/lifecycle/q;",
            ">(",
            "Ljava/lang/String;",
            "Ljava/lang/Class<",
            "TT;>;)TT;"
        }
    .end annotation

    .line 122
    .local p2, "modelClass":Ljava/lang/Class;, "Ljava/lang/Class<TT;>;"
    iget-object v0, p0, Landroid/arch/lifecycle/r;->b:Landroid/arch/lifecycle/s;

    invoke-virtual {v0, p1}, Landroid/arch/lifecycle/s;->a(Ljava/lang/String;)Landroid/arch/lifecycle/q;

    move-result-object v0

    .line 124
    .local v0, "viewModel":Landroid/arch/lifecycle/q;
    invoke-virtual {p2, v0}, Ljava/lang/Class;->isInstance(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_0

    .line 126
    return-object v0

    .line 129
    :cond_0
    nop

    .line 134
    iget-object v1, p0, Landroid/arch/lifecycle/r;->a:Landroid/arch/lifecycle/r$a;

    invoke-interface {v1, p2}, Landroid/arch/lifecycle/r$a;->a(Ljava/lang/Class;)Landroid/arch/lifecycle/q;

    move-result-object v0

    .line 135
    iget-object v1, p0, Landroid/arch/lifecycle/r;->b:Landroid/arch/lifecycle/s;

    invoke-virtual {v1, p1, v0}, Landroid/arch/lifecycle/s;->a(Ljava/lang/String;Landroid/arch/lifecycle/q;)V

    .line 137
    return-object v0
.end method
