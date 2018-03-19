package bitcamp.java106.pms;

import java.util.Scanner;

import bitcamp.java106.pms.controller.BoardController;
import bitcamp.java106.pms.controller.MemberController;
import bitcamp.java106.pms.controller.TeamController;
import bitcamp.java106.pms.util.Console;

public class App {
    static Scanner keyScan = new Scanner(System.in);
    static String option = null;

    static void onQuit() {
        System.out.println("안녕히 가세요!"); 
    }

    static void onHelp() {
        System.out.println("[도움말]");
        System.out.println("팀 등록 명령 : team/add"); 
        System.out.println("팀 조회 명령 : team/list");
        System.out.println("팀 상세조회 명령 : team/view 팀명");
        System.out.println("회원 등록 명령 : member/add");
        System.out.println("회원 조회 명령 : member/list");
        System.out.println("회원 상세조회 명령 : member/view 아이디");
        System.out.println("종료 : quit");
    }

    public static void main(String[] args) {
        TeamController.keyScan = keyScan;
        MemberController.keyScan = keyScan;
        BoardController.keyScan = keyScan;
        Console.keyScan = keyScan;

        while (true) {
            String[] input = Console.prompt();
            String menu = input[0];

            if (input.length == 2) {
                option = input[1]; 
            } else {
                option = null;
            }

            if (menu.equals("quit")) {
                onQuit();
                break;
            } else if (menu.equals("help")) {
                onHelp();
            } else if (menu.startsWith("team/")) {
                TeamController.service(menu, option);
            } else if (menu.startsWith("member/")) {
                MemberController.service(menu, option);
            } else if (menu.startsWith("board/")) {
                BoardController.service(menu, option);
            } else {
                System.out.println("명령어가 올바르지 않습니다.");
            }

            System.out.println();
        }
    }
}