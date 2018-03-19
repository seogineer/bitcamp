package bitcamp.java106.pms;

import bitcamp.java106.pms.domain.Team;
import bitcamp.java106.pms.domain.Member;
import java.util.Scanner;
import java.util.StringTokenizer;

public class App {
    static Scanner keyScan = new Scanner(System.in);

    static Team[] teams = new Team[100];
    static Member[] members = new Member[100];
    static int teamIndex = 0;
    static int memberIndex = 0;
    static String option = null;

    static String[] prompt() {
        System.out.print("명령> ");
        return keyScan.nextLine().toLowerCase().split(" ");
    }

    static void onQuit() {
        System.out.println("안녕히가세요!");
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

    static void onTeamAdd() {
        System.out.println("[팀 정보 입력]");
        Team team = new Team();

        System.out.print("팀명? ");
        team.name = keyScan.nextLine();
        
        System.out.print("설명? ");
        team.description = keyScan.nextLine();
        
        System.out.print("최대인원? ");
        team.maxQty = keyScan.nextLine();
        
        System.out.print("시작일? ");
        team.startDate = keyScan.nextLine();
        
        System.out.print("종료일? ");
        team.endDate = keyScan.nextLine();
        
        System.out.printf("%s, %s, %s, %s, %s\n", team.name, 
            team.description, team.maxQty, 
            team.startDate, team.endDate);
        
        teams[teamIndex++] = team;
    }

    static void onTeamList() {
        System.out.println("[팀 목록]");
        for (int i = 0; i < teamIndex; i++) {
            if(teams[i] == null) continue;
            System.out.printf("%s, %s명, %s ~ %s\n", teams[i].name,
                teams[i].maxQty, teams[i].startDate, teams[i].endDate);
        }
    }

    static void onTeamView() {
        System.out.println("[팀 정보 조회]");
        if (option == null) {
            System.out.println("팀명을 입력하시기 바랍니다.");
            return;
        } else {
            boolean teamCheck = true;
            for (int i = 0; i < teamIndex; i++) {
                if (option.equals(teams[i].name.toLowerCase())) {
                    System.out.printf("팀명: %s\n", teams[i].name);
                    System.out.printf("설명: %s\n", teams[i].description);
                    System.out.printf("인원: %s\n", teams[i].maxQty);
                    System.out.printf("기간: %s ~ %s\n", teams[i].startDate, teams[i].endDate);
                    teamCheck = false;
                }
            }
            if (teamCheck) {
                System.out.println("해당 이름의 팀이 없습니다.");
            }
        }
    }

    static void onTeamUpdate() {
        System.out.println("[팀 정보 변경]");
        if (option == null) {
            System.out.println("팀명을 입력하시기 바랍니다.");
            System.out.println();
            return;
        } else {
            boolean teamCheck = true;
            for (int i = 0; i < teamIndex; i++) {
                if (option.equals(teams[i].name.toLowerCase())) {
                    System.out.printf("팀명(%s)? ", teams[i].name);
                    teams[i].name = keyScan.nextLine();
                    System.out.printf("설명(%s)? ", teams[i].description);
                    teams[i].description = keyScan.nextLine();
                    System.out.printf("최대인원(%s)? ", teams[i].maxQty);
                    teams[i].maxQty = keyScan.nextLine();
                    System.out.printf("시작일(%s)? ", teams[i].startDate);
                    teams[i].startDate = keyScan.nextLine();
                    System.out.printf("종료일(%s)? ", teams[i].endDate);
                    teams[i].endDate = keyScan.nextLine();
                    System.out.println("변경하였습니다.");
                    teamCheck = false;
                }
            }
            if (teamCheck) {
                System.out.println("해당 이름의 팀이 없습니다.");
            }
        }
    }

    static void onTeamDelete() {
        System.out.println("[팀 정보 삭제]");
        if (option == null) {
            System.out.println("팀명을 입력하시기 바랍니다.");
            System.out.println();
            return;
        } else {
            boolean teamCheck = true;
            for (int i = 0; i < teamIndex; i++) {
                if (option.equals(teams[i].name.toLowerCase())) {
                    System.out.print("정말 삭제하시겠습니까?(Y/N) ");
                    String cmd = keyScan.nextLine().toLowerCase();
                    if(cmd.equals("y")){
                        if(i + 1 == teams.length){
                            teams[i] = null;
                            teamIndex--;
                        }else {
                            for(int j = i + 1; j < teams.length; j++){
                                teams[i] = teams[j];
                            }
                            teamIndex--;
                        }
                        teamCheck = false;
                        System.out.println("삭제하였습니다.");
                    } else if(cmd.equals("n")){
                        teamCheck = false;
                    }
                }
            }
            if (teamCheck) {
                System.out.println("해당 이름의 팀이 없습니다.");
            }
        }
    }

    static void onMemberAdd() {
        System.out.println("[회원 정보 입력]");
        Member member = new Member();

        System.out.print("아이디? ");
        member.id = keyScan.nextLine();
        
        System.out.print("이메일? ");
        member.email = keyScan.nextLine();
        
        System.out.print("암호? ");
        member.password = keyScan.nextLine();

        members[memberIndex++] = member;
    }

    static void onMemberList() {
        System.out.println("[회원 목록]");
        for (int i = 0; i < memberIndex; i++) {
            System.out.printf("%s, %s, %s\n", members[i].id, members[i].email, members[i].password);
        }
    }

    static void onMemberView() {
        System.out.println("[회원 정보 조회]");
        if (option == null) {
            System.out.println("아이디를 입력하시기 바랍니다.");
            return;
        } else {
            boolean memCheck = true;
            for (int i = 0; i < memberIndex; i++) {
                if (option.equals(members[i].id.toLowerCase())) {
                    System.out.println("아이디: " + members[i].id);
                    System.out.println("이메일: " + members[i].email);
                    System.out.println("암호: " + members[i].password);
                    memCheck = false;
                }
            }
            if (memCheck) {
                System.out.println("해당 아이디의 회원이 없습니다.");
            }
        }
    }

    static void onMemberUpdate() {
        System.out.println("[회원 정보 변경]");
        if (option == null) {
            System.out.println("아이디를 입력하시기 바랍니다.");
            System.out.println();
            return;
        } else {
            boolean memCheck = true;
            for (int i = 0; i < memberIndex; i++) {
                if (option.equals(members[i].id.toLowerCase())) {
                    System.out.printf("아이디(%s)? ", members[i].id);
                    members[i].id = keyScan.nextLine();
                    System.out.printf("이메일(%s)? ", members[i].email);
                    members[i].email = keyScan.nextLine();
                    System.out.printf("암호? ");
                    members[i].password = keyScan.nextLine();
                    System.out.println("변경하였습니다.");
                    memCheck = false;
                }
            }
            if (memCheck) {
                System.out.println("해당 아이디의 회원이 없습니다.");
            }
        }
    }

    static void onMemberDelete() {
        System.out.println("[회원 정보 삭제]");
        if (option == null) {
            System.out.println("아이디를 입력하시기 바랍니다.");
            System.out.println();
            return;
        } else {
            boolean memCheck = true;
            for (int i = 0; i < memberIndex; i++) {
                if (option.equals(members[i].id.toLowerCase())) {
                    System.out.print("정말 삭제하시겠습니까?(Y/N) ");
                    String cmd = keyScan.nextLine().toLowerCase();
                    if(cmd.equals("y")){
                        if(i + 1 == members.length){
                            members[i] = null;
                            memberIndex--;
                        }else {
                            for(int j = i + 1; j < members.length; j++){
                                members[i] = members[j];
                            }
                            memberIndex--;
                        }
                        memCheck = false;
                        System.out.println("삭제하였습니다.");
                    } else if(cmd.equals("n")){
                        memCheck = false;
                    }
                }
            }
            if (memCheck) {
                System.out.println("해당 아이디의 회원이 없습니다.");
            }
        }
    }

    public static void main(String[] args) {

        while (true) {
            String[] cmd = prompt();
            String menu = cmd[0];

            if (cmd.length == 2) {
                option = cmd[1];
            } else {
                option = null;
            }

            if (menu.equals("quit")) {
                onQuit();
                break;
            } else if (menu.equals("help")) {
                onHelp();
            } else if (menu.equals("team/add")) {
                onTeamAdd();
            } else if (menu.equals("team/list")) {
                onTeamList();
            } else if (menu.equals("team/view")) {
                onTeamView();
            } else if (menu.equals("team/update")) {
                onTeamUpdate();
            } else if (menu.equals("team/delete")) {
                onTeamDelete();
            } else if (menu.equals("member/add")) {
                onMemberAdd();
            } else if (menu.equals("member/list")) {
                onMemberList();
            } else if (menu.equals("member/view")) {
                onMemberView();
            } else if (menu.equals("member/update")) {
                onMemberUpdate();
            } else if (menu.equals("member/delete")) {
                onMemberDelete();
            } else {
                System.out.println("명령어가 올바르지 않습니다.");
            }

            System.out.println();
        }
    }
}