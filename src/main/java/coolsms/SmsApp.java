package coolsms;

import com.solapi.sdk.SolapiClient;
import com.solapi.sdk.message.exception.SolapiMessageNotReceivedException;
import com.solapi.sdk.message.model.Message;
import com.solapi.sdk.message.service.DefaultMessageService;

public class SmsApp {
    public static void main(String[] args) {
        DefaultMessageService messageService =  SolapiClient.INSTANCE.createInstance("NCSSLSAFYF8PUZER", "PNUMHTEDC7Y0VNZC34WSZPHAZPYYLTH3");
// Message 패키지가 중복될 경우 com.solapi.sdk.message.model.Message로 치환하여 주세요
        Message message = new Message();
        message.setFrom("01033116837");
        message.setTo("01022227460");
        message.setText("[이지윤]안녕하세요 저는 SMS를 테스트하는 중 입니다.");

        try {
            // send 메소드로 ArrayList<Message> 객체를 넣어도 동작합니다!
            messageService.send(message);
        } catch (SolapiMessageNotReceivedException exception) {
            // 발송에 실패한 메시지 목록을 확인할 수 있습니다!
            System.out.println(exception.getFailedMessageList());
            System.out.println(exception.getMessage());
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
        }
    }
}
