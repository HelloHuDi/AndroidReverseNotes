.class public Landroid/arch/lifecycle/CompositeGeneratedAdaptersObserver;
.super Ljava/lang/Object;
.source ""

# interfaces
.implements Landroid/arch/lifecycle/GenericLifecycleObserver;


# instance fields
.field private final a:[Landroid/arch/lifecycle/c;


# direct methods
.method constructor <init>([Landroid/arch/lifecycle/c;)V
    .locals 0
    .param p1, "generatedAdapters"    # [Landroid/arch/lifecycle/c;

    .line 30
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 31
    iput-object p1, p0, Landroid/arch/lifecycle/CompositeGeneratedAdaptersObserver;->a:[Landroid/arch/lifecycle/c;

    .line 32
    return-void
.end method


# virtual methods
.method public a(Landroid/arch/lifecycle/f;Landroid/arch/lifecycle/d$a;)V
    .locals 6
    .param p1, "source"    # Landroid/arch/lifecycle/f;
    .param p2, "event"    # Landroid/arch/lifecycle/d$a;

    .line 36
    new-instance v0, Landroid/arch/lifecycle/l;

    invoke-direct {v0}, Landroid/arch/lifecycle/l;-><init>()V

    .line 37
    .local v0, "logger":Landroid/arch/lifecycle/l;
    iget-object v1, p0, Landroid/arch/lifecycle/CompositeGeneratedAdaptersObserver;->a:[Landroid/arch/lifecycle/c;

    array-length v2, v1

    const/4 v3, 0x0

    const/4 v4, 0x0

    :goto_0
    if-ge v4, v2, :cond_0

    aget-object v5, v1, v4

    .line 38
    .local v5, "mGenerated":Landroid/arch/lifecycle/c;
    invoke-interface {v5, p1, p2, v3, v0}, Landroid/arch/lifecycle/c;->a(Landroid/arch/lifecycle/f;Landroid/arch/lifecycle/d$a;ZLandroid/arch/lifecycle/l;)V

    .line 37
    .end local v5    # "mGenerated":Landroid/arch/lifecycle/c;
    add-int/lit8 v4, v4, 0x1

    goto :goto_0

    .line 40
    :cond_0
    iget-object v1, p0, Landroid/arch/lifecycle/CompositeGeneratedAdaptersObserver;->a:[Landroid/arch/lifecycle/c;

    array-length v2, v1

    :goto_1
    if-ge v3, v2, :cond_1

    aget-object v4, v1, v3

    .line 41
    .local v4, "mGenerated":Landroid/arch/lifecycle/c;
    const/4 v5, 0x1

    invoke-interface {v4, p1, p2, v5, v0}, Landroid/arch/lifecycle/c;->a(Landroid/arch/lifecycle/f;Landroid/arch/lifecycle/d$a;ZLandroid/arch/lifecycle/l;)V

    .line 40
    .end local v4    # "mGenerated":Landroid/arch/lifecycle/c;
    add-int/lit8 v3, v3, 0x1

    goto :goto_1

    .line 43
    :cond_1
    return-void
.end method
