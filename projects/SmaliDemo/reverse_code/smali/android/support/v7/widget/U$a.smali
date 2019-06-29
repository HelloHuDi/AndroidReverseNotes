.class Landroid/support/v7/widget/U$a;
.super Ljava/lang/Object;
.source ""

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Landroid/support/v7/widget/U;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x2
    name = "a"
.end annotation


# instance fields
.field final synthetic a:Landroid/support/v7/widget/U;


# direct methods
.method constructor <init>(Landroid/support/v7/widget/U;)V
    .locals 0

    .line 1341
    iput-object p1, p0, Landroid/support/v7/widget/U$a;->a:Landroid/support/v7/widget/U;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 1342
    return-void
.end method


# virtual methods
.method public run()V
    .locals 1

    .line 1346
    iget-object v0, p0, Landroid/support/v7/widget/U$a;->a:Landroid/support/v7/widget/U;

    invoke-virtual {v0}, Landroid/support/v7/widget/U;->a()V

    .line 1347
    return-void
.end method
