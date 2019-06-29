.class Landroid/support/v7/widget/P$b;
.super Ljava/lang/Object;
.source ""

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Landroid/support/v7/widget/P;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x2
    name = "b"
.end annotation


# instance fields
.field final synthetic a:Landroid/support/v7/widget/P;


# direct methods
.method constructor <init>(Landroid/support/v7/widget/P;)V
    .locals 0

    .line 329
    iput-object p1, p0, Landroid/support/v7/widget/P$b;->a:Landroid/support/v7/widget/P;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 330
    return-void
.end method


# virtual methods
.method public run()V
    .locals 1

    .line 334
    iget-object v0, p0, Landroid/support/v7/widget/P$b;->a:Landroid/support/v7/widget/P;

    invoke-virtual {v0}, Landroid/support/v7/widget/P;->d()V

    .line 335
    return-void
.end method
