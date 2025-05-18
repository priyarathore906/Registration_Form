package com.course.registration.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;

@Service
public class EmailService {

    @Autowired
    private JavaMailSender mailSender;

    public void sendMail(String toEmail, String name, String college, String contact, List<String> courses, String timing) {
        try {
            MimeMessage message = mailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message, true);

            helper.setTo(toEmail);
            helper.setSubject("✅ Course Registration Successful");

            String htmlContent = String.format("""
                <html>
                  <body style="font-family: Arial, sans-serif; background-color: #f4f4f4; padding: 20px;">
                    <div style="max-width: 600px; margin: auto; background-color: #ffffff; border-radius: 10px; padding: 30px; box-shadow: 0 2px 8px rgba(0,0,0,0.1);">
                      <h2 style="color: #2e86de; text-align: center;">🎉 Registration Confirmed!</h2>
                      <p>Dear <strong>%s</strong>,</p>
                      <p>Thank you for registering for our <strong>Coding Course</strong>. We have received your registration details and we are excited to have you onboard.</p>

                      <h3 style="color: #444;">📋 Registration Details:</h3>
                      <ul style="line-height: 1.6;">
                        <li><strong>College:</strong> %s</li>
                        <li><strong>Contact:</strong> %s</li>
                        <li><strong>Courses:</strong> %s</li>
                        <li><strong>Preferred Timing:</strong> %s</li>
                      </ul>

                      <p>We will get in touch with you soon with further information. Till then, stay curious and keep coding! 💻</p>

                      <hr style="margin-top: 30px;"/>
                      <p style="font-size: 0.9em; color: #888; text-align: center;">
                        Regards, <br/>
                        <strong>Your Coding Academy Team</strong><br/>
                        📧 support@youracademy.com
                      </p>
                    </div>
                  </body>
                </html>
            """, name, college, contact, String.join(", ", courses), timing);

            helper.setText(htmlContent, true);
            mailSender.send(message);
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }
}
