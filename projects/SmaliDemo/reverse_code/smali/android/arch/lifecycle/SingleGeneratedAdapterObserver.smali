.class public Landroid/arch/lifecycle/SingleGeneratedAdapterObserver;
.super Ljava/lang/Object;
.source ""

# interfaces
.implements Landroid/arch/lifecycle/GenericLifecycleObserver;


# instance fields
.field private final a:Landroid/arch/lifecycle/c;


# direct methods
.method constructor <init>(Landroid/arch/lifecycle/c;)V
    .locals 0
    .param p1, "generatedAdapter"    # Landroid/arch/lifecycle/c;

    .line 29
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 30
    iput-object p1, p0, Landroid/arch/lifecycle/SingleGeneratedAdapterObserver;->a:Landroid/arch/lifecycle/c;

    .line 31
    return-void
.end method


# virtual methods
.method public a(Landroid/arch/lifecycle/f;Landroid/arch/lifecycle/d$a;)V
    .locals 3
    .param p1, "source"    # Landroid/arch/lifecycle/f;
    .param p2, "event"    # Landroid/arch/lifecycle/d$a;

    .line 35
    iget-object v0, p0, Landroid/arch/lifecycle/SingleGeneratedAdapterObserver;->a:Landroid/arch/lifecycle/c;

    const/4 v1, 0x0

    const/4 v2, 0x0

    invoke-interface {v0, p1, p2, v2, v1}, Landroid/arch/lifecycle/c;->a(Landroid/arch/lifecycle/f;Landroid/arch/lifecycle/d$a;ZLandroid/arch/lifecycle/l;)V

    .line 36
    iget-object v0, p0, Landroid/arch/lifecycle/SingleGeneratedAdapterObserver;->a:Landroid/arch/lifecycle/c;

    const/4 v2, 0x1

    invoke-interface {v0, p1, p2, v2, v1}, Landroid/arch/lifecycle/c;->a(Landroid/arch/lifecycle/f;Landroid/arch/lifecycle/d$a;ZLandroid/arch/lifecycle/l;)V

    .line 37
    return-void
.end method
