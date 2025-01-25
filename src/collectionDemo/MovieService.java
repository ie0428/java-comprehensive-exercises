package collectionDemo;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MovieService {
    // 4、准备一个集合容器：存储全部上架的电影数据。
    private static List<Movie> movies = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public void start() {

        while (true) {
            // 3、准备操作界面:GUI界面/cmd命令做。
            System.out.println("====电影信息操作系统===");
            System.out.println("1、上架");
            System.out.println("2、下架某个电影");
            System.out.println("3、查询某个电影");
            System.out.println("4、封杀某个明星");
            System.out.println("5、修改某个电影");
            System.out.println("6、展示全部电影");
            System.out.println("7、退出");
            System.out.println("请您输入操作命令：");
            String command = scanner.next();
            switch (command){
                case "1":
                    // 上架(独立功能独立成方法)
                    addMovie();
                    break;
                case "2":
                    // 下架某个电影
                    deleteMovie();
                    break;
                case "3":
                    // 查询某个电影
                    queryMovie();
                    break;
                case "4":
                    // 封杀某个明星
                    deleteStar();
                    break;
                case "5":
                    // 修改某个电影
                    updateMovie();
                    break;
                case "6":
                    // 展示全部电影
                    queryAllMovies();
                    break;
                case "7":
                    System.out.println("退出成功！");
                    return;
                default:
                    System.out.println("命令有问题！");

            }
        }
    }


    /**
         * 修改某个电影
         */
    private void updateMovie() {
        System.out.println("===========修改电影============");
        System.out.println("请输入要修改的电影名称：");
        String name = scanner.next();
        for (int i = 0; i < movies.size(); i++) {
            Movie movie = movies.get(i);
            if (movie.getName().equals(name)) {
                System.out.println("请输入要修改的内容：");
                System.out.println("1、修改电影名称");
                System.out.println("2、修改电影评分");
                System.out.println("3、修改电影主演");
                System.out.println("4、修改电影价格");
                int choice = scanner.nextInt();
                switch (choice) {
                    case 1:
                        System.out.println("请输入新的电影名称：");
                        movie.setName(scanner.next());
                        break;
                    case 2:
                        System.out.println("请输入新的电影评分：");
                        movie.setScore(scanner.nextDouble());
                        break;
                    case 3:
                        System.out.println("请输入新的电影主演：");
                        movie.setActor(scanner.next());
                }
                System.out.println("修改成功！");
                return;
            }
        }
    }

    /**
         * 展示全部电影
         */
    private void queryAllMovies() {
        System.out.println("===========展示全部电影============");
        for (Movie movie : movies) {
            System.out.println(movie);
        }
    }

    /**
         * 封杀某个明星
         */
    private void deleteStar() {
        System.out.println("===========封杀明星============");
        System.out.println("请输入要封杀的明星：");
        String star = scanner.next();
        for (int i = 0; i < movies.size(); i++) {
            Movie movie = movies.get(i);
            if (movie.getActor().equals(star)) {
                movies.remove(i);
                i--;// 退一步
            }
        }
        System.out.println("封杀成功！");
        // 展示全部电影。
        queryAllMovies();
    }

    /**
         * 查询电影信息
         */
    private void queryMovie() {
        System.out.println("===========查询电影============");
        System.out.println("请输入要查询的电影名称：");
        String name = scanner.next();
        Movie movie = queryMovieByName(name);
        if (movie == null) {
            System.out.println("没有找到这个电影！");
        } else {
            System.out.println(movie);
        }

    }

    // 根据电影名称查询电影对象返回
    // movies = [m1, m2, m3 , ...]
    //                              m
    public Movie queryMovieByName(String name) {
        for (Movie m : movies) {
            if (m.getName().equals(name)) {
                return m; // 找到这个电影对象
            }
        }
        return null; // 没有找到这个电影对象
    }

    /**
     * 下架电影
     */
    private void deleteMovie() {
        System.out.println("===========下架电影============");
        System.out.println("请输入要下架的电影名称：");
        String name = scanner.next();
        for (int i = 0; i < movies.size(); i++) {
            Movie movie = movies.get(i);
            if (movie.getName().equals(name)) {
                movies.remove(i);
                System.out.println("下架成功！");
                return;
            }
        }
    }

    /**
     * 上架电影
     */
    private void addMovie() {
        System.out.println("===========上架电影============");
        //1.创建电影对象封装这些电影信息
        Movie movie = new Movie();

        //2.提示用户输入电影信息
        System.out.println("请输入电影名称：");
        movie.setName(scanner.next());
        System.out.println("请输入电影评分：");
        movie.setScore(scanner.nextDouble());
        System.out.println("请输入电影主演：");
        movie.setActor(scanner.next());
        System.out.println("请输入电影价格：");
        movie.setPrice(scanner.nextDouble());

        //3.将电影对象添加到集合中
        movies.add(movie);
        System.out.println("上架成功！");
    }
}
