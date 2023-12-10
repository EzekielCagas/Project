using System.Text;
using System.Windows;
using System.Windows.Controls;
using System.Windows.Data;
using System.Windows.Documents;
using System.Windows.Input;
using System.Windows.Media;
using System.Windows.Media.Imaging;
using System.Windows.Navigation;
using System.Windows.Shapes;
using MoreBullets.ViewModels;
using MoreBullets.Views;

namespace MoreBullets
{
    /// <summary>
    /// Interaction logic for MainWindow.xaml
    /// </summary>
    public partial class MainWindow : Window
    {
        GuestViewModel viewModel;
        public MainWindow()
        {
            InitializeComponent();
            viewModel = new GuestViewModel();
            Main.Content = new HomePage();

        }
        private void BtnClickLogBook(object sender, RoutedEventArgs e)
        {
            Main.Content = new GuestView { DataContext = viewModel };
            
        }
        private void BtnClickAbout(object sender, RoutedEventArgs e)
        {
            Main.Content = new About();
        }
    }
}