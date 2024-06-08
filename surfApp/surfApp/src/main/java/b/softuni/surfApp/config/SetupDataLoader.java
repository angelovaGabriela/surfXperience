package b.softuni.surfApp.config;

//@Component
//public class SetupDataLoader implements ApplicationListener<ContextRefreshedEvent> {
//
//    boolean alreadySetup = false;
//    private final UserRepository userRepository;
//    private final RoleRepository roleRepository;
//    private final PrivilegeRepository privilegeRepository;
//    private final PasswordEncoder passwordEncoder;
//
//    public SetupDataLoader(UserRepository userRepository,
//                           RoleRepository roleRepository,
//                           PrivilegeRepository privilegeRepository,
//                           PasswordEncoder passwordEncoder) {
//        this.userRepository = userRepository;
//        this.roleRepository = roleRepository;
//        this.privilegeRepository = privilegeRepository;
//        this.passwordEncoder = passwordEncoder;
//    }
//
//    @Override
//    @Transactional
//    public void onApplicationEvent(ContextRefreshedEvent event) {
//
//        if (alreadySetup)
//            return;
//        PrivilegeEntity readPrivilege
//                = createPrivilegeIfNotFound("READ_PRIVILEGE");
//        PrivilegeEntity writePrivilege
//                = createPrivilegeIfNotFound("WRITE_PRIVILEGE");
//
//        List<PrivilegeEntity> adminPrivileges = Arrays.asList(
//                readPrivilege, writePrivilege);
//        createRoleIfNotFound("ROLE_ADMIN", adminPrivileges);
//        createRoleIfNotFound("ROLE_USER", Collections.singletonList(readPrivilege));
//
//        UserRoleEntity adminRole = roleRepository.findByName("ROLE_ADMIN");
//        UserEntity user = new UserEntity();
//        user.setFirstName("Test");
//        user.setLastName("Test");
//        user.setPassword(passwordEncoder.encode("test"));
//        user.setEmail("test@test.com");
//        user.setRoles(Collections.singletonList(adminRole));
//        user.setEnabled(true);
//        userRepository.save(user);
//
//        alreadySetup = true;
//    }
//
//    @Transactional
//    PrivilegeEntity createPrivilegeIfNotFound(String name) {
//
//        PrivilegeEntity privilegeEntity = privilegeRepository.findByName(name);
//        if (privilegeEntity == null) {
//            privilegeEntity = new PrivilegeEntity(name);
//            privilegeRepository.save(privilegeEntity);
//        }
//        return privilegeEntity;
//    }
//
//    @Transactional
//    UserRoleEntity createRoleIfNotFound(
//            String name, List<PrivilegeEntity> privileges) {
//
//        UserRoleEntity role = roleRepository.findByName(name);
//        if (role == null) {
//            role = new UserRoleEntity(name);
//            role.setPrivileges(privileges);
//            roleRepository.save(role);
//        }
//        return role;
//    }
//}
